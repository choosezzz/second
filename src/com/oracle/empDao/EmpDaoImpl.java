package com.oracle.empDao;

import java.util.List;

import com.oracle.jdbc.util.Dao;
import com.oracle.tools.PageInfo;
import com.oracle.vo.Emp;

public class EmpDaoImpl implements EmpDao {

	

	@Override
	public Emp getById(Integer id) {
		
		return Dao.queryOne("select * from tb_emp where empid= ?", Emp.class, id);
	}

	@Override
	public Emp getByName(String name) {
		return Dao.queryOne("select * from tb_emp where empName= ?", Emp.class, name);
	}

	@Override
	public void save(Emp emp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Emp e) {
		
		Dao.executeSql("UPDATE `tb_emp` SET `Password`=?, `EmpName`=?,dutyId=?, sex=?,`birth`=?, `idCard`=?, `email`=?, `Tel`=?, `Address`=?, `empType`=?, `BankName`=?, `BankNo`=?, `Sal`=?, `comm`=?, `subsidy`=?, `Descript`=? WHERE (`EmpID`=?)", e.getPassword(),e.getEmpName(),e.getDutyId(),e.getSex(),e.getBirth(),e.getIdCard(),e.getEmail(),e.getTel(),e.getAddress(),e.getEmpType(),e.getBankName(),e.getBankNo(),e.getSal(),e.getComm(),e.getSubsidy(),e.getDescript(),e.getEmpId());

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Emp login(String empNo,String pwd) {
		
		return Dao.queryOne("select * from tb_emp where empNo=? and password=?", Emp.class,empNo,pwd);
	}

	@Override
	public void getAll(PageInfo info) {

		// 查询总记录条数
		Object[] obj = Dao.queryOne("select count(*) from tb_emp");
		// 类型转换,设置参数
		info.setRecordCount(((Long) obj[0]).intValue());
		// 查询当前页信息
		List<Emp> list = Dao.query("select * from tb_emp order by empId limit ? ,?", Emp.class,(info.getCurrentPage() - 1) * info.getPageSize(), info.getPageSize());
		// 赋值
		info.setList(list);
	}

	@Override
	public List<Emp> getAll() {

		return Dao.query("select * from tb_emp", Emp.class);
	
	}
	
	

}
