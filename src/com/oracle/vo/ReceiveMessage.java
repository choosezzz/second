package com.oracle.vo;

import java.sql.Date;

public class ReceiveMessage {
	
	Integer recevieId;//收件id
	Integer sendId;//发件id
	Integer empId;//员工id
	Integer massageState;//消息状态
	Date openDate;//打开时间
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
