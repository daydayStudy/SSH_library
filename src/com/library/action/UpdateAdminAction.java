package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import oracle.net.aso.p;




import com.library.bean.Admin;
import com.library.bean.Reader;
import com.library.dao.AdminDao;
import com.library.dao.ReaderDao;
import com.library.impl.AdminImpl;
import com.library.impl.ReaderImpl;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateAdminAction extends ActionSupport implements ServletResponseAware{

	
	public  Admin admin;
	private AdminDao adao = new AdminImpl();
	private HttpServletResponse response;



   



	







	public Admin getAdmin() {
		return admin;
	}















	public void setAdmin(Admin admin) {
		this.admin = admin;
	}















	@Override
    public String execute() throws Exception {
		if(adao.update(admin)){
			return SUCCESS;
		}
		else{
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");        	
			PrintWriter out= response.getWriter();
			out.print("<script>alert('更新失败')</script>");
			out.print("<script>window.location.href='home.jsp'</script>");   
			out.flush();   
			out.close();	
		return INPUT;}
    }

    
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
}

