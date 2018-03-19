package com.oracle.vo;

import java.sql.Date;

public class Emp {
	
	Integer empId;//员工ID
	Integer roleId;//角色
	Integer dutyId;//职务
	String empNo;//员工编号
	String password;//密码
	String empName;//员工姓名
	String sex;//性别
	Date birth;//生日
	Integer age;//年龄
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	String idCard;//身份证号
	String email;//邮箱
	String tel;//电话
	String address;//地址
	String empType;//员工类型
	String bankName;//银行名称
	String bankNo;//银行账号
	Integer sal;//工资
	Integer comm; //奖金
	Integer subsidy;//补助
	public Integer getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(Integer subsidy) {
		this.subsidy = subsidy;
	}
	Date hireDate;//雇佣时间
	String descript;//描述
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
