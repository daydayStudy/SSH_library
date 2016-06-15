package com.library.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.p;

import com.library.bean.BookType;
import com.library.dao.BookTypeDao;
import com.library.impl.BookTypeImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;


public class SelectbtforjspAction extends ActionSupport {

	private String method;
	private String id;
	private BookType booktype;
	private BookTypeDao selectdao = new BookTypeImpl();

	
	
	



	public BookType getBooktype() {
		return booktype;
	}



	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}



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







	public String execute() throws Exception{
		select();
	
		return SUCCESS;
    }

	public void select() {
		if("select".equals(method)) { 
        	if(JUtils.changeToNum(id)) {
        		System.out.println("id="+id);
        		System.out.println("method="+method);
        		int typeid = Integer.parseInt(id);
        		booktype=selectdao.get(typeid);
        		
        	}
        }
	}
    
        
}

