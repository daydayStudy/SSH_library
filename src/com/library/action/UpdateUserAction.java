package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.p;


import com.library.bean.Reader;
import com.library.dao.ReaderDao;
import com.library.impl.ReaderImpl;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateUserAction extends ActionSupport {

	
	public  Reader reader;
	private ReaderDao rdao = new ReaderImpl();



   



	public Reader getReader() {
		return reader;
	}







	public void setReader(Reader reader) {
		this.reader = reader;
	}







	@Override
    public String execute() throws Exception {
		if(rdao.updateReader(reader)){
			return SUCCESS;
		}
		else{
	
		return INPUT;}
    }

    
        
}

