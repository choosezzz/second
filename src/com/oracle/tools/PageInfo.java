package com.oracle.tools;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo {
	
	private Integer pageSize;//ÿҳ��Ϣ����
	private Integer pageCount;//��ҳ��
	private Integer currentPage=1;//��ǰҳ
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	private Integer recordCount;//��¼����
	private String uri;//���ʵ�uri
	private List list=new ArrayList<Object>();//��¼ÿҳ����Ϣ
	
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
	//���췽��
	public PageInfo(HttpServletRequest request) {
		
		this.setUri(request.getRequestURI());
		//��������Ϣ�л��Ҫ��ѯ��ҳ��
		String page=request.getParameter("currentPage");
		//Ĭ�ϵ�һҳ
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
