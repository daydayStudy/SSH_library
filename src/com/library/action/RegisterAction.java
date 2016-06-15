package com.library.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import oracle.net.aso.p;

import com.library.bean.Reader;
import com.library.dao.ReaderDao;
import com.library.impl.ReaderImpl;
import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport {

	private Reader reader;
	private ReaderDao readerDao = new ReaderImpl();

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
    public String execute() throws Exception {
       
		if(readerDao.addReader(reader)){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("reader", reader);
			
			return SUCCESS;
		}       
		return INPUT;
    }

    
        
}

