package com.oracle.vo;

import java.sql.Date;
import java.util.Arrays;

public class SendMessage {
	
	Integer sendId;//��Ϣid
	Integer empId;//������id
	Integer[] rec_empIds;//�����ߵ�id
	String messageTitle;//��Ϣ����
	String messageContent;//��Ϣ����
	Date createDate;//��������
	Integer priority;//���ȼ�
	Integer massageState;//��Ϣ״̬
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	
	public Integer[] getRec_empIds() {
		return rec_empIds;
	}
	public void setRec_empIds(Integer[] rec_empIds) {
		this.rec_empIds = rec_empIds;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Integer getMassageState() {
		return massageState;
	}
	public void setMassageState(Integer massageState) {
		this.massageState = massageState;
	}
	@Override
	public String toString() {
		return "SendMessage [sendId=" + sendId + ", empId=" + empId + ", rec_empIds=" + Arrays.toString(rec_empIds)
				+ ", messageTitle=" + messageTitle + ", messageContent=" + messageContent + ", createDate=" + createDate
				+ ", priority=" + priority + ", massageState=" + massageState + "]";
	}

}
