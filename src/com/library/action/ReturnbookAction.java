package com.library.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.p;

import com.library.bean.BookInfo;
import com.library.bean.BookType;
import com.library.bean.Borrow;
import com.library.bean.Reader;
import com.library.bean.Stock;
import com.library.dao.BookInfoDao;
import com.library.dao.BookTypeDao;
import com.library.dao.BorrowDao;
import com.library.dao.ReaderDao;
import com.library.dao.StockDao;
import com.library.impl.BookInfoImpl;
import com.library.impl.BookTypeImpl;
import com.library.impl.BorrowImpl;
import com.library.impl.ReaderImpl;
import com.library.impl.StockImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionSupport;


public class ReturnbookAction extends ActionSupport {

	private String method;
	private String id;
	private Borrow borrow;
	private Stock stock;
	private BorrowDao bordao =new BorrowImpl();
	private StockDao stcdao = new StockImpl();
	

   
    

	

	public Borrow getBorrow() {
		return borrow;
	}



	public void setBorrow(Borrow borrow) {
		this.borrow = borrow;
	}



	public Stock getStock() {
		return stock;
	}



	public void setStock(Stock stock) {
		this.stock = stock;
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
        		stock=stcdao.getStock(isbn);
        		stock.setAmount(stock.getAmount()-1);
        		stcdao.updateStock(stock);
        		borrow=bordao.getBorrow(isbn);
        		borrow.setIsback(1);
        		bordao.updateBorrow(borrow);
        	}
        }
	}
    
        
}

