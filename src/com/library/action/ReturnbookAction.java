package com.library.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

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
	HttpServletResponse response;
	

   
    

	

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
		return SUCCESS;
    }

	public void borrow()  {
		if("select".equals(method)) { 
        	if(JUtils.changeToNum(id)) {
        		System.out.println("id="+id);
        		System.out.println("method="+method);
        		String isbn = id;   
        		borrow=bordao.getBorrow(isbn);
        		long day = borrow.getBackdate().getTime() -borrow.getBorrowdate().getTime()/(24*60*60*1000); 
        		if(day>0){
        			stock=stcdao.getStock(isbn);
            		stock.setAmount(stock.getAmount()-1);
            		stcdao.updateStock(stock);       		
            		borrow.setIsback(1);
            		bordao.updateBorrow(borrow);
            		
        		}
        		else {
        			response.setContentType("text/html;charset=UTF-8");
        			response.setCharacterEncoding("UTF-8");
        			PrintWriter out;
        			/*out.print("<script>alert('需交罚款')</script>");
        			out.print("<script>window.location.href='" + "returnbook_manager.jsp" + "'</script>");   
        			out.flush();   
        			out.close();*/
        			
        		}
        	}
        }
		
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
        
}

