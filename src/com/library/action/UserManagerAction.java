package com.library.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.PageBean;
import com.library.impl.ReaderImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagerAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ReaderImpl readerImpl;
	private String method;
	private String id;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private int page;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public String execute() throws Exception {
		pageInfo();
		delete();
        return SUCCESS;
	}
	
	/**
	 * 分页信息
	 */
	private void pageInfo() {
		//表示每页显示5条记录，page表示当前网页
        PageBean pageBean = readerImpl.getPageBean(11, page);
        System.out.println("page="+page);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("userPageBean", pageBean);
	}
	
	public void delete() {
		if("delete".equals(method)) { //删除会员
        	if(JUtils.changeToNum(id)) {
        		System.out.println("id="+id);
        		System.out.println("method="+method);
        		int readerid = Integer.parseInt(id);
        		readerImpl.deleteReader(readerid);
        		pageInfo();
        	}
        }
	}

}
