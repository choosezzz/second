package com.oracle.empDao;

import java.util.List;

import com.oracle.tools.PageInfo;
import com.oracle.vo.Emp;

public interface EmpDao {
	
	/**
	 * ��ѯȫ��
	 * @return
	 */
	public void getAll(PageInfo info);
	/**
	 * ����id��ѯ
	 * @param id
	 * @return
	 */
	public Emp getById(Integer id);
	
	/**
	 * ��¼
	 * @param emp
	 * @return
	 */
	public Emp login(String empNo,String pwd);
	/**
	 * ����������ѯ
	 * @param name
	 * @return
	 */
	public Emp getByName(String name);
	/**
	 * �������û�
	 * @param emp
	 */
	public void save(Emp emp);
	/**
	 * �޸���Ϣ
	 * @param emp
	 */
	public void update(Emp emp);
	/**
	 * ����idɾ��
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * ��ѯȫ��
	 * @return
	 */
	public List<Emp> getAll();

}
