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


public class AddbookTypeAction extends ActionSupport {

	
	public  BookType booktype;
	private BookTypeDao stdao = new BookTypeImpl();





	public BookType getBooktype() {
		return booktype;
	}





	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}





	@Override
    public String execute() throws Exception {
		if(stdao.addType(booktype)){
			return SUCCESS;
		}
		else{
	
		return INPUT;}
    }

    
        
}

