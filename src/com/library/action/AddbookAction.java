package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

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


public class AddbookAction extends ActionSupport implements ServletResponseAware{

	private BookInfo book;	
	public  BookType booktype;
	private Stock stock;
	public int typeid;
	private BookInfoDao bookDao = new BookInfoImpl();
	private BookTypeDao stdao = new BookTypeImpl();
	private StockDao stcdao = new StockImpl();
	private HttpServletResponse response;

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
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('添加图书失败')</script>");
			out.print("<script>window.location.href='bookManager.action'</script>");   
			out.flush();   
			out.close();		
	
		return INPUT;}
    }
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
    
        
}

