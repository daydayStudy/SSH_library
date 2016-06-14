package com.library.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.p;

import com.library.bean.BookType;
import com.library.bean.Reader;
import com.library.dao.BookTypeDao;
import com.library.dao.ReaderDao;
import com.library.impl.BookTypeImpl;
import com.library.impl.ReaderImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;


public class selectredforjspAction extends ActionSupport {

	private String method;
	private String id;
	public  Reader reader;
	private ReaderDao rdao = new ReaderImpl();

	
	



	public Reader getReader() {
		return reader;
	}



	public void setReader(Reader reader) {
		this.reader = reader;
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
        		int readerid = Integer.parseInt(id);
        		reader=rdao.getuser(readerid);
        		
        	}
        }
	}
    
        
}

