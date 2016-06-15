package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import oracle.net.aso.p;



import com.library.bean.Reader;
import com.library.dao.ReaderDao;
import com.library.impl.ReaderImpl;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateUserAction extends ActionSupport implements ServletResponseAware{

	
	public  Reader reader;
	private ReaderDao rdao = new ReaderImpl();
	private HttpServletResponse response;


   



	public Reader getReader() {
		return reader;
	}







	public void setReader(Reader reader) {
		this.reader = reader;
	}







	@Override
    public String execute() throws Exception {
		if(rdao.updateReader(reader)){
			return SUCCESS;
		}
		else{
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('更新失败')</script>");
			out.print("<script>window.location.href='userManager.action'</script>");   
			out.flush();   
			out.close();	
		return INPUT;}
    }

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
        
}

