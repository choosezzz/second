package com.oracle.vo;

import java.sql.Date;

public class ReceiveMessage {
	
	Integer recevieId;//�ռ�id
	Integer sendId;//����id
	Integer empId;//Ա��id
	Integer massageState;//��Ϣ״̬
	Date openDate;//��ʱ��
	public Integer getRecevieId() {
		return recevieId;
	}
	public void setRecevieId(Integer recevieId) {
		this.recevieId = recevieId;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getMassageState() {
		return massageState;
	}
	public void setMassageState(Integer massageState) {
		this.massageState = massageState;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	@Override
	public String toString() {
		return "ReceiveMassage [recevieId=" + recevieId + ", sendId=" + sendId + ", empId=" + empId + ", massageState="
				+ massageState + ", openDate=" + openDate + "]";
	}

}
