package com.oracle.tools;

import java.util.Date;
import java.text.SimpleDateFormat;

public class BirthConvertAge {
	
	public static Integer convert(Date d){
		//��ȡ��ǰ�¼�
		Date now_date=new Date(System.currentTimeMillis());
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String[] now=df.format(now_date).split("-");
		String[] birth=df.format(d).split("-");
		Integer year=Integer.valueOf(now[0])-Integer.valueOf(birth[0]);
		Integer month=Integer.valueOf(now[1])-Integer.valueOf(birth[1]);
		Integer day=Integer.valueOf(now[2])-Integer.valueOf(birth[2]);
		//��������
		if(month>=0&&day>0){
			return year+1; 
		}else if(month==0&&day==0){
			//�պ�����
			return year;
		}else{
			//û������
			return year-1;
		}
	}
	
}
