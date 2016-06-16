package com.library.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import oracle.net.aso.p;

import com.library.bean.Reader;
import com.library.dao.ReaderDao;
import com.library.impl.ReaderImpl;
import com.opensymphony.xwork2.ActionSupport;


public class RegisterAction extends ActionSupport implements ServletResponseAware{

	private Reader reader;
	private ReaderDao readerDao = new ReaderImpl();
	private HttpServletResponse response;

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@Override
    public String execute() throws Exception {
       
		if(readerDao.addReader(reader)){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("reader", reader);
			
			return SUCCESS;
		}    
		else{
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");        	
		PrintWriter out= response.getWriter();
		out.print("<script>alert('注册失败')</script>");
		out.print("<script>window.location.href='register.jsp'</script>");   
		out.flush();   
		out.close();	
		return INPUT;}
    }

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
        
}

