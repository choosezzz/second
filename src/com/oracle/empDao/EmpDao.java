package com.oracle.empDao;

import java.util.List;

import com.oracle.tools.PageInfo;
import com.oracle.vo.Emp;

public interface EmpDao {
	
	/**
	 * 查询全部
	 * @return
	 */
	public void getAll(PageInfo info);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Emp getById(Integer id);
	
	/**
	 * 登录
	 * @param emp
	 * @return
	 */
	public Emp login(String empNo,String pwd);
	/**
	 * 根据姓名查询
	 * @param name
	 * @return
	 */
	public Emp getByName(String name);
	/**
	 * 保存新用户
	 * @param emp
	 */
	public void save(Emp emp);
	/**
	 * 修改信息
	 * @param emp
	 */
	public void update(Emp emp);
	/**
	 * 根据id删除
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 查询全部
	 * @return
	 */
	public List<Emp> getAll();

}
