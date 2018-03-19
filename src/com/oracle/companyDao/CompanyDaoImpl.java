package com.oracle.companyDao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.jdbc.util.Dao;
import com.oracle.jdbc.util.Transactional;
import com.oracle.tools.PageInfo;
import com.oracle.vo.Company;

public class CompanyDaoImpl implements CompanyDao {

	@Override
	@Transactional
	public void save(Company c) {

		Dao.executeSql(
				"INSERT INTO `tb_company` (`CompanyName`, `Linkman`, `Tel`, `Address`, `CreateDate`, `Descript`) VALUES (?, ?, ?, ?, now(), ?)",
				c.getCompanyName(), c.getLinkMan(), c.getTel(), c.getAddress(), c.getDescript());

	}

	@Override
	public Company getById(Integer id) {

		return Dao.queryOne("select * from tb_company where companyId= ?", Company.class, id);
	}

	@Override
	@Transactional
	public void delete(Integer[] ids) {

		// 根据ids长度生成sql语句
		StringBuffer sql = new StringBuffer("delete from tb_company where companyid in (");
		// sql中间部分
		for (int i = 0; i < ids.length - 1; i++) {
			sql.append(" ?, ");
		}
		// sql最后一个参数
		sql.append("?)");
		Dao.execute(sql.toString(), ids);

	}

	@Override
	public void getByPage(PageInfo info) {

		// 查询总记录条数
		Object[] obj = Dao.queryOne("select count(*) from tb_company");
		// 类型转换,设置参数
		info.setRecordCount(((Long) obj[0]).intValue());
		// 查询当前页信息
		List<Company> list = Dao.query("select * from tb_company order by companyId limit ? ,?", Company.class,
				(info.getCurrentPage() - 1) * info.getPageSize(), info.getPageSize());
		// 赋值
		info.setList(list);
	}

	@Override
	public List<Company> getAll() {

		return Dao.query("select * from tb_company", Company.class);
	}

	@Override
	@Transactional
	public void update(Company c) {

		Dao.executeSql(
				"update tb_company set companyName= ? , linkMan = ? , address = ? , descript = ? , tel = ?  where companyId = ? ",
				c.getCompanyName(), c.getLinkMan(), c.getAddress(), c.getDescript(), c.getTel(), c.getCompanyId());

	}

	@Override
	public void getOnePageInfo(PageInfo info, Integer id) {
		// 每页只显示一条记录
		info.setPageSize(1);

		// 判断是否时第一次请求
		if (id != null) {
			// 查询总记录条数
			Object[] currentPage = Dao.queryOne("select count(*) from tb_company where companyId < ?", id);
			// 类型转换,设置当前条数参数
			info.setCurrentPage(((Long) currentPage[0]).intValue() + 1);
		}

		// 查询总记录条数
		Object[] obj = Dao.queryOne("select count(*) from tb_company");
		// 类型转换,设置参数
		info.setRecordCount(((Long) obj[0]).intValue());
		// 查询当前页信息
		List<Company> list = Dao.query("select * from tb_company order by companyId limit ? ,?", Company.class,
				(info.getCurrentPage() - 1) * info.getPageSize(), info.getPageSize());
		// 赋值
		info.setList(list);
	}

	@Override
	public void selectBycompanyName(PageInfo info, String name) {

		String companyName="%"+name+"%";
		// 查询满足条件的总记录条数
		Object[] obj = Dao.queryOne("select count(*) from tb_company where companyName like ?",companyName);
		// 类型转换,设置参数
		info.setRecordCount(((Long) obj[0]).intValue());
		// 查询当前页信息
		List<Company> list = Dao.query("select * from tb_company where CompanyName like ?  ORDER BY CompanyID LIMIT ?,?", Company.class,companyName,(info.getCurrentPage() - 1) * info.getPageSize(), info.getPageSize());
		// 赋值
		info.setList(list);

	}

}
