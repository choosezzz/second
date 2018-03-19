package com.oracle.messageDao;

import com.oracle.tools.PageInfo;
import com.oracle.vo.SendMessage;

public interface MessageDao {
	
	/**
	 * ������Ϣ
	 * @param m
	 */
	public void sendMassage(SendMessage m);
	/**
	 * �鿴�յ�����Ϣ
	 * @param id
	 * @param info
	 */
	public void viewMassage(Integer id,PageInfo info);
	
	/**
	 * ɾ���û����յ���Ϣ
	 * @param receiveId��Ҫɾ������Ϣid
	 */
	public void deleteReceiveMessageById(Integer receiveId);
	
	/**
	 * ����ɾ�����յ�����Ϣ
	 * @param ids
	 */
	public void batchDeleteReceiveMessage(Integer[] ids);
	/**
	 * ��ҳ�鿴���͵���Ϣ ��¼
	 * @param id
	 * @return
	 */
	public void listSendMessage(PageInfo info,Integer id);
	
	/**
	 * ����idɾ�����͵���Ϣ
	 * @param sendId
	 * @param empId
	 */
	public void deleteSendMessageById(Integer sendId);
	/**
	 * ����ɾ��������Ϣ
	 * @param sendId
	 * @param empId
	 */
	public void batchDeleteSendMessage(Integer[] sendIds);
	/**
	 * �鿴������Ϣ����ϸ����
	 * @param info
	 * @param id
	 */
	public void viewSendMessage(PageInfo info,Integer empid,Integer...id);
	/**
	 * �鿴�ռ�����Ϣ����
	 * @param info
	 * @param id
	 */
	public void viewReceiveMessage(PageInfo info,Integer empId,Integer id);

}
