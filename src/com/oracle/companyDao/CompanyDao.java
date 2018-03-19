package com.oracle.companyDao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.tools.PageInfo;
import com.oracle.vo.Company;

public interface CompanyDao {
	
	/**
	 * ��ҳ��ѯ
	 * @return
	 */
	public void getByPage(PageInfo info);
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Company> getAll();
	/**
	 * �����µĿͻ���Ϣ
	 * @param conpany
	 */
	public void save(Company company);
	
	/**
	 * ����id��ѯĳ����˾��Ϣ
	 * @param id
	 * @return
	 */
	public Company getById(Integer id);
	
	/**
	 * ����ɾ��
	 * @param ids
	 */
	public void delete(Integer[] ids);
	
	/**
	 * �޸���Ϣ
	 * @param c
	 */
	public void update(Company c);
	
	/**
	 * ��ҳ��ÿҳ��������ʾ��ʱ�����id��ѯ��ǰ���ݵ�ҳ����Ϣ
	 * @param id
	 * @return
	 */
	public void getOnePageInfo(PageInfo info,Integer id); 
	
	/**
	 * ����name��ѯ��ʵ�ַ�ҳ����
	 * @param info
	 * @param name
	 */
	public void selectBycompanyName(PageInfo info,String name);

}
