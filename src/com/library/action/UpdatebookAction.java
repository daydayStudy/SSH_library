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


public class UpdatebookAction extends ActionSupport implements ServletResponseAware{

	
	private BookInfo book;	
	private Stock stock;
	public int typeid;
	private  BookType booktype;
	private BookTypeDao stdao = new BookTypeImpl();
	private BookInfoDao bookDao = new BookInfoImpl();
	private StockDao stcdao = new StockImpl();
	private HttpServletResponse response;

   


	


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








	public Stock getStock() {
		return stock;
	}








	public void setStock(Stock stock) {
		this.stock = stock;
	}


   





	








	@Override
    public String execute() throws Exception {		
		this.booktype = stdao.get(typeid);
		book.setBookType(booktype);
		stock.setBookInfo(book);
		if(bookDao.updateBook(book) && stcdao.updateStock(stock) ){
			return SUCCESS;
		}
		else{
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('更新失败')</script>");
			out.print("<script>window.location.href='bookManager.action'</script>");   
			out.flush();   
			out.close();	
		return INPUT;}
    }

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
        
}

