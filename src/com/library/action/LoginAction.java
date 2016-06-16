package com.library.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.library.impl.AdminImpl;
import com.library.impl.ReaderImpl;
import com.library.util.JUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletResponse response;
	private String name;
	private String pwd;
	private String selected;
	@Resource
	private ReaderImpl readerImpl;
	@Resource
	private AdminImpl adminImpl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	@Override
	public String execute() throws Exception {
		return "login";
	}

	public String login() throws IOException {
		if(checkLogin()) {
			ActionContext context=ActionContext.getContext();
			//��session���
			context.getSession().put("loginName",name);
			PrintWriter out = response.getWriter();
			out.print("<script>window.location.href='" + "home.jsp" + "'</script>");   
			out.flush();   
			out.close();
			
//			return SUCCESS;
		} else {
			ActionContext context=ActionContext.getContext();
			//��session���
			context.getSession().put("loginName",null);
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");//��ֹ��������Ϣ�������� 
			PrintWriter out = response.getWriter();
			out.print("<script>alert('登录失败')</script>");
			out.print("<script>window.location.href='" + "home.jsp" + "'</script>");   
			out.flush();   
			out.close();
		}

		return null;
	}

	public boolean checkLogin() { //1304001
		System.out.println("ѡ��="+selected);
		if("1".equals(selected)) { //�û�
			if(JUtils.changeToNum(name)) {
				int id = Integer.parseInt(name);
				System.out.println("id="+id);
				return readerImpl.login(id, pwd);
			} else {
				return false;
			}
		} else { //����Ա
			if(JUtils.changeToNum(name)) {
				int id = Integer.parseInt(name);
				return adminImpl.login(id, pwd);
			} else {
				return false;
			}
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
