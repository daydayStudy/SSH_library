package com.library.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.p;

import com.library.bean.BookType;
import com.library.dao.BookTypeDao;
import com.library.impl.BookTypeImpl;
import com.opensymphony.xwork2.ActionSupport;


public class sSelectAction extends ActionSupport {

	public List<BookType> list;

	private BookTypeDao selectdao = new BookTypeImpl();

	





	public List<BookType> getList() {
		return list;
	}



	public void setList(List<BookType> list) {
		this.list = list;
	}



	public String execute() throws Exception{
		list= selectdao.selectType("from BookType");
	
		return SUCCESS;
    }

    
        
}

