package com.library.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.library.bean.PageBean;
import com.library.impl.ReaderImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserManagerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ReaderImpl readerImpl;
	private int page;

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public String execute() throws Exception {
		//��ʾÿҳ��ʾ5����¼��page��ʾ��ǰ��ҳ
        PageBean pageBean = readerImpl.getPageBean(1, page);
        System.out.println("page="+page);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("userPageBean", pageBean);
        
        return SUCCESS;
	}

}
