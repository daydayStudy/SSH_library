package com.library.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.p;



import com.library.bean.Admin;
import com.library.bean.Reader;
import com.library.dao.AdminDao;
import com.library.dao.ReaderDao;
import com.library.impl.AdminImpl;
import com.library.impl.ReaderImpl;
import com.opensymphony.xwork2.ActionSupport;


public class UpdateAdminAction extends ActionSupport {

	
	public  Admin admin;
	private AdminDao adao = new AdminImpl();



   



	







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
	
		return INPUT;}
    }

    
        
}

