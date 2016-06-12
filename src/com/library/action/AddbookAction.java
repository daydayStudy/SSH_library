package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.p;








import com.library.bean.BookInfo;
import com.library.bean.BookType;
import com.library.dao.BookInfoDao;
import com.library.dao.BookTypeDao;
import com.library.impl.BookInfoImpl;
import com.library.impl.BookTypeImpl;
import com.opensymphony.xwork2.ActionSupport;


public class AddbookAction extends ActionSupport {

	private BookInfo book;	
	public  BookType booktype;
	public int typeid;
	private BookInfoDao bookDao = new BookInfoImpl();
	private BookTypeDao stdao = new BookTypeImpl();
	
	

	
   



	public int getTypeid() {
		return typeid;
	}



	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}



	
	public BookInfo getBook() {		
		return book;
	}

 

	public void setBook(BookInfo book) {
		
		this.book = book;
	}



	@Override
    public String execute() throws Exception {
		this.booktype = stdao.get(typeid);
		book.setBookType(booktype);
		if(bookDao.addBook(book)){
			return SUCCESS;
		}
		else{
	
		return INPUT;}
    }

    
        
}

