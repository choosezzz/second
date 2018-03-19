package com.oracle.companyDao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.tools.PageInfo;
import com.oracle.vo.Company;

public interface CompanyDao {
	
	/**
	 * 分页查询
	 * @return
	 */
	public void getByPage(PageInfo info);
	/**
	 * 查询所有
	 * @return
	 */
	public List<Company> getAll();
	/**
	 * 保存新的客户信息
	 * @param conpany
	 */
	public void save(Company company);
	
	/**
	 * 根据id查询某个公司信息
	 * @param id
	 * @return
	 */
	public Company getById(Integer id);
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);
	
	/**
	 * 修改信息
	 * @param c
	 */
	public void update(Company c);
	
	/**
	 * 当页面每页条单独显示的时候根据id查询当前数据的页数信息
	 * @param id
	 * @return
	 */
	public void getOnePageInfo(PageInfo info,Integer id); 
	
	/**
	 * 根据name查询，实现分页功能
	 * @param info
	 * @param name
	 */
	public void selectBycompanyName(PageInfo info,String name);

}
