package com.library.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.p;

import com.library.bean.BookInfo;
import com.library.bean.BookType;
import com.library.bean.Reader;
import com.library.bean.Stock;
import com.library.dao.BookInfoDao;
import com.library.dao.BookTypeDao;
import com.library.dao.ReaderDao;
import com.library.dao.StockDao;
import com.library.impl.BookInfoImpl;
import com.library.impl.BookTypeImpl;
import com.library.impl.ReaderImpl;
import com.library.impl.StockImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;


public class SelectbookforjspAction extends ActionSupport {

	private String method;
	private String id;
	private BookInfo book;
	private  List<BookType> list;
	private Stock stock;
	private BookTypeDao stdao = new BookTypeImpl();
	private StockDao stcdao = new StockImpl();
	private BookInfoDao bookDao = new BookInfoImpl();


    

	

	public Stock getStock() {
		return stock;
	}



	public void setStock(Stock stock) {
		this.stock = stock;
	}



	



	

	


	public BookInfo getBook() {
		return book;
	}



	public void setBook(BookInfo book) {
		this.book = book;
	}



	



	public List<BookType> getList() {
		return list;
	}



	public void setList(List<BookType> list) {
		this.list = list;
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
        		String isbn = id;
        		book=bookDao.getBook(isbn);
        		list= stdao.selectType("from BookType");       
        		stock=stcdao.getStock(isbn);
        		
        	}
        }
	}
    
        
}

