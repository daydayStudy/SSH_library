package com.library.action;

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
			return SUCCESS;
		}       
		return INPUT;
    }

    
        
}

