package com.oracle.vo;

import java.sql.Date;

public class Emp {
	
	Integer empId;//Ա��ID
	Integer roleId;//��ɫ
	Integer dutyId;//ְ��
	String empNo;//Ա�����
	String password;//����
	String empName;//Ա������
	String sex;//�Ա�
	Date birth;//����
	Integer age;//����
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	String idCard;//���֤��
	String email;//����
	String tel;//�绰
	String address;//��ַ
	String empType;//Ա������
	String bankName;//��������
	String bankNo;//�����˺�
	Integer sal;//����
	Integer comm; //����
	Integer subsidy;//����
	public Integer getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(Integer subsidy) {
		this.subsidy = subsidy;
	}
	Date hireDate;//��Ӷʱ��
	String descript;//����
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getDutyId() {
		return dutyId;
	}
	public void setDutyId(Integer dutyId) {
		this.dutyId = dutyId;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public Integer getSal() {
		return sal;
	}
	public void setSal(Integer sal) {
		this.sal = sal;
	}
	public Integer getComm() {
		return comm;
	}
	public void setComm(Integer comm) {
		this.comm = comm;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", roleId=" + roleId + ", dutyId=" + dutyId + ", empNo=" + empNo + ", password="
				+ password + ", empName=" + empName + ", sex=" + sex + ", birth=" + birth + ", age=" + age + ", idCard="
				+ idCard + ", email=" + email + ", tel=" + tel + ", address=" + address + ", empType=" + empType
				+ ", bankName=" + bankName + ", bankNo=" + bankNo + ", sal=" + sal + ", comm=" + comm + ", subsidy="
				+ subsidy + ", hireDate=" + hireDate + ", descript=" + descript + "]";
	}
	
}
