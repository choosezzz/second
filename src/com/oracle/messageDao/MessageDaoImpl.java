package com.oracle.messageDao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.jdbc.util.Transactional;
import com.oracle.tools.PageInfo;
import com.oracle.vo.ReceiveMessage;
import com.oracle.vo.SendMessage;

public class MessageDaoImpl implements MessageDao {

	/**
	 * ������Ϣ
	 */
	@Override
	@Transactional
	public void sendMassage(SendMessage m) {

		// ��ȡ��ǰ�������ֵ
		long id = (long) Dao.queryOne("select max(sendId)+1 from to_sendmessage")[0];
		// SendMessage message=Dao.queryOne("select max(sendId)+1 sendId from
		// to_sendmessage", SendMessage.class);
		// System.out.println(message.getSendId());
		// �洢���͵���Ϣ
		Dao.executeSql(
				"insert into to_sendMessage (`sendID`, `EmpID`, `MessageTitle`, `MessageContent`, `CreateDate`, `priority`, `MessageState`) values(?,?,?,?,now(),?,1)",
				id, m.getEmpId(), m.getMessageTitle(), m.getMessageContent(), m.getPriority());
		// �������Ϣ���в����¼
		Integer[] empIds = m.getRec_empIds();
		for (int i = 0; i < empIds.length; i++) {
			Dao.executeSql(
					"insert into to_receiveMessage (receiveID,sendId,empId,messageState,openDate) values(null,?,?,1,null)",
					id, empIds[i]);
		}
	}

	/**
	 * ��ҳ��ʾ
	 */
	@Override
	public void viewMassage(Integer id, PageInfo info) {

		info.setRecordCount(((Long) Dao.queryOne(
				"select count(*) from to_receivemessage r LEFT JOIN to_sendmessage s on s.sendID=r.sendID LEFT JOIN tb_emp e on s.EmpID=e.EmpID WHERE r.MessageState!=3 and r.EmpID=?",
				id)[0]).intValue());
		List<Object[]> list = Dao.query(
				"select r.ReceiveID,s.MessageTitle MessageTitle,s.MessageContent MessageContent,EmpName empName,r.openDate openDate , CASE when r.MessageState=1 then 'δ��' when r.MessageState=2 then '�Ѷ�' END  MessageState from to_receivemessage r LEFT JOIN to_sendmessage s on s.sendID=r.sendID LEFT JOIN tb_emp e on s.EmpID=e.EmpID WHERE r.MessageState!=3 and r.EmpID= ? order by r.receiveId limit ?,?",
				id, (info.getCurrentPage() - 1) * info.getPageSize(), info.getPageSize());
		info.setList(list);
	}

	@Override
	public void listSendMessage(PageInfo info, Integer id) {

		// ��ѯ��Ϣ����
		info.setRecordCount(
				((Long) Dao.queryOne("select count(*) from to_sendmessage where EmpID=? and MessageState!=2", id)[0])
						.intValue());
		// ��ѯ���͵�������Ϣ��n+1ģʽ��
		// List<Object[]> list=Dao.query("select s.sendID sendID,s.MessageTitle
		// MessageTitle,s.MessageContent MessageContent,s.CreateDate sendTime,
		// '' receiver from to_sendmessage s LEFT JOIN to_receivemessage r on
		// r.sendID=s.sendID LEFT JOIN tb_emp e on e.EmpID=s.EmpID where
		// s.EmpID= ? order by s.sendId limit ?,?", id,(info.getCurrentPage() -
		// 1) * info.getPageSize(), info.getPageSize());
		List<Object[]> list = Dao.query(
				"select sendid,messageTitle,messageContent,createDate,'' empName from to_sendMessage where empId=? and messageState != 2 order by createDate desc,priority desc,sendId asc limit ? ,?",
				id, (info.getCurrentPage() - 1) * info.getPageSize(), info.getPageSize());
		// ��ѯÿ����Ϣ��Ӧ�����н�����
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = list.get(i);// ��ȡ��ǰ��ѯ�������
			// ��ѯ��ÿ����Ϣ��Ӧ�������ռ���
			// List<Object[]> names=Dao.query("select e.EmpName recevier from
			// tb_emp e LEFT JOIN to_receivemessage r on e.EmpID=r.EmpID where
			// r.sendID=?",obj[0]);
			List<Object[]> names = Dao.query(
					"select empName from tb_emp where empId in (select empId from to_receiveMessage where sendId= ? )",
					obj[0]);
			StringBuffer sb = new StringBuffer();
			for (int k = 0; k < names.size(); k++) {
				if (k == names.size() - 1) {
					sb.append(names.get(k)[0]);
				} else {
					sb.append(names.get(k)[0]).append(",");
				}
			}
			// ��������λ�ø�ֵ
			obj[obj.length - 1] = sb.toString();
		}
		// ��ҳ��ʾ����
		info.setList(list);
	}

	@Override
	public void deleteReceiveMessageById(Integer receiveId) {

		Dao.executeSql("UPDATE `to_receivemessage` SET `MessageState`='3' WHERE (`receiveID`=?)", receiveId);
	}

	@Override
	public void batchDeleteReceiveMessage(Integer[] ids) {

		StringBuffer sql = new StringBuffer(
				"UPDATE `to_receivemessage` SET `MessageState`='2' WHERE `receiveId` in ( ");
		for (int i = 0; i < ids.length; i++) {
			if (i == ids.length - 1) {
				sql.append(ids[i] + " )");
			} else {
				sql.append(ids[i] + " ,");
			}
		}
		Dao.executeSql(sql.toString());
	}

	@Override
	public void deleteSendMessageById(Integer sendId) {

		Dao.executeSql("UPDATE `to_sendmessage` SET `MessageState`='2' WHERE (`sendID`=?)", sendId);
	}

	@Override
	@Transactional
	public void batchDeleteSendMessage(Integer[] sendIds) {

		StringBuffer sql = new StringBuffer("UPDATE `to_sendmessage` SET `MessageState`='2' WHERE `sendID` in ( ");
		for (int i = 0; i < sendIds.length; i++) {
			if (i == sendIds.length - 1) {
				sql.append(sendIds[i] + " )");
			} else {
				sql.append(sendIds[i] + " ,");
			}
		}
		Dao.executeSql(sql.toString());
	}

	@Override
	public void viewSendMessage(PageInfo info, Integer empId, Integer... id) {
		// ÿҳֻ��ʾһ����¼
		info.setPageSize(1);
		// �ж��Ƿ�ʱ��һ������
		if (id != null) {
			// ��ѯ�ܼ�¼����
			Object[] currentPage = Dao.queryOne(
					"select count(*) from to_sendmessage where sendid < ? and empid=? and messageState!='2'", id[0],
					empId);
			// ����ת��,���õ�ǰ��������
			info.setCurrentPage(((Long) currentPage[0]).intValue() + 1);
		}
		// SendMessage message=Dao.queryOne("select * from to_sendmessage where
		// sendId= ?", SendMessage.class, id[0]);
		// ���÷�ҳ��ѯ����
		listSendMessage(info, empId);
	}

	@Override
	public void viewReceiveMessage(PageInfo info, Integer empId, Integer id) {
		// ÿҳֻ��ʾһ����¼
		info.setPageSize(1);
		// �ж��Ƿ�ʱ��һ������
		if (id != null) {

			ReceiveMessage r=Dao.queryOne("select * from to_receivemessage where receiveId=? and openDate is null", ReceiveMessage.class, id);
			//δ����Ϣ���ò鿴ʱ��
			if(r!=null){
				Dao.executeSql("update to_receivemessage set openDate=now(),messageState=2 where receiveId=?",id);
			}
			// ��ѯ�ܼ�¼����
			Object[] currentPage = Dao.queryOne(
					"select count(*) from to_receivemessage where receiveid < ? and empid=? and messageState!='3'", id,
					empId);
			// ����ת��,���õ�ǰ��������
			info.setCurrentPage(((Long) currentPage[0]).intValue() + 1);
		}
		
		// SendMessage message=Dao.queryOne("select * from to_sendmessage where
		// sendId= ?", SendMessage.class, id[0]);
		// ���÷�ҳ��ѯ����
		viewMassage(empId,info);

	}

}
