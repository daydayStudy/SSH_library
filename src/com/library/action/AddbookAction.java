package com.library.action;

import oracle.net.aso.p;





import com.library.bean.BookInfo;
import com.library.dao.BookInfoDao;
import com.library.impl.BookInfoImpl;
import com.opensymphony.xwork2.ActionSupport;


public class AddbookAction extends ActionSupport {

	private BookInfo book;
	private BookInfoDao bookDao = new BookInfoImpl();



	public BookInfo getBook() {
		return book;
	}



	public void setBook(BookInfo book) {
		this.book = book;
	}



	@Override
    public String execute() throws Exception {
       
		if(bookDao.addBook(book)){
			return SUCCESS;
		}       
		return INPUT;
    }

    
        
}

