package com.oracle.tools;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	
	private Integer pageSize;//每页信息条数
	private Integer pageCount;//总页数
	private Integer currentPage=1;//当前页
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	private Integer recordCount;//记录总数
	private String uri;//访问的uri
	private List list=new ArrayList<Object>();//记录每页的信息
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCount() {
		return (int) Math.ceil(this.recordCount/(double)this.pageSize);
	}
	//构造方法
	public PageInfo(HttpServletRequest request) {
		
		this.setUri(request.getRequestURI());
		//从请求信息中获得要查询的页数
		String page=request.getParameter("currentPage");
		//默认第一页
		if(page!=null){
			this.currentPage=Integer.valueOf(page);
		}
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	@Override
	public String toString() {
		return "PageInfo [pageSize=" + pageSize + ", pageCount=" + pageCount + ", currentPage=" + currentPage
				+ ", recordCount=" + recordCount + ", uri=" + uri + ", list=" + list + "]";
	}

}
