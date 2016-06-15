package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import oracle.net.aso.p;









import com.library.bean.BookInfo;
import com.library.bean.BookType;
import com.library.dao.BookInfoDao;
import com.library.dao.BookTypeDao;
import com.library.impl.BookInfoImpl;
import com.library.impl.BookTypeImpl;
import com.opensymphony.xwork2.ActionSupport;


public class AddbookTypeAction extends ActionSupport implements ServletResponseAware{

	
	public  BookType booktype;
	private BookTypeDao stdao = new BookTypeImpl();
	private HttpServletResponse response;




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
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
				PrintWriter out= response.getWriter();
				out.print("<script>alert('添加图书类型失败')</script>");
				out.print("<script>window.location.href='btypeManager.action'</script>");   
				out.flush();   
				out.close();		
		return INPUT;}
    }

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
        
}

