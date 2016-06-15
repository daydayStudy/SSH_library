package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.p;











import com.library.bean.BookInfo;
import com.library.bean.BookType;
import com.library.bean.Stock;
import com.library.dao.BookInfoDao;
import com.library.dao.BookTypeDao;
import com.library.dao.StockDao;
import com.library.impl.BookInfoImpl;
import com.library.impl.BookTypeImpl;
import com.library.impl.StockImpl;
import com.opensymphony.xwork2.ActionSupport;


public class AddbookAction extends ActionSupport {

	private BookInfo book;	
	public  BookType booktype;
	private Stock stock;
	public int typeid;
	private BookInfoDao bookDao = new BookInfoImpl();
	private BookTypeDao stdao = new BookTypeImpl();
	private StockDao stcdao = new StockImpl();
	
	

	
   



	public Stock getStock() {
		return stock;
	}



	public void setStock(Stock stock) {
		this.stock = stock;
	}



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
		stock.setBookInfo(book);
		if(bookDao.addBook(book) && stcdao.addStock(stock)){
			return SUCCESS;
		}
		else{
	
		return INPUT;}
    }

    
        
}

