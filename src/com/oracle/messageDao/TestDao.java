package com.oracle.messageDao;

import java.util.Arrays;
import java.util.List;

import com.oracle.jdbc.util.ServiceFactory;
import com.oracle.vo.SendMessage;

public class TestDao {

	public static void main(String[] args) {
		
		MessageDao dao=ServiceFactory.getObject(MessageDaoImpl.class);
		SendMessage m=new SendMessage();
//		m.setPriority(1);
//		m.setEmpId(1);
//		m.setMessageContent("ÄãºÃ");
//		m.setMassageState(1);
//		m.setMessageTitle("hello");
//		m.setRec_empIds(new Integer[]{1,2});
//		dao.sendMassage(m);
//		List<Object[]> list=dao.viewMassage(2);
//		for(int i=0;i<list.size();i++){
//			System.out.println(Arrays.deepToString(list.get(i)));
//		}
		
//		List<Object[]> list=dao.listSendMessage(1);
//		for(int i=0;i<list.size();i++){
//			System.out.println(Arrays.deepToString(list.get(i)));
//		}
		
	}

}
