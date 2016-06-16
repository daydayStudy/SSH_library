<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:useBean id="reader" scope="page" class="com.library.bean.Reader"/>
<jsp:setProperty  name="reader" property="readerid" />
<jsp:setProperty  name="reader" property="name" />
<jsp:setProperty  name="reader" property="pwd" />
<jsp:setProperty  name="reader" property="age" />
<jsp:setProperty  name="reader" property="sex" />
<jsp:setProperty  name="reader" property="tel" />
<jsp:setProperty  name="reader" property="pwd" />
<jsp:setProperty  name="reader" property="email" />
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 			+ request.getServerName() + ":" + request.getServerPort()
 			+ path + "/";

 	//<!--  required="required" placeholder="用户名" autocomplete="off"  -->
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style3.css"
	title="Origo" media="all">
<script type="text/javascript" src="js/userRegisterCheck.js" charset="UTF-8"></script>
<title>Origo v1.1</title>

</head>

<body class="light">
	
	<div style="text-align: center;">
		<img src="images/logo.jpg">
		</div>
		<hr>
		
	<center>
		 注册成功！许锋你个傻鸟<br/>		 
		 
		 
  欢迎你，<s:property value="#request.reader.name"/>会员注册成功！！！<br/>
  你的注册信息如下:<br/>
用户ID：<s:property value="#request.reader.readerid" /></br>
姓名：<s:property value="#request.reader.name"/></br>
密码：<s:property value="#request.reader.pwd"/></br>
年龄：<s:property value="#request.reader.age"/></br>
性别：<s:property value="#request.reader.sex"/></br>
联系方式：<s:property value="#request.reader.tel"/></br>
邮箱：<s:property value="#request.reader.email"/></br>
  <a href=home.jsp>进入主页</a>
		
     
		
</center>

	

</body>
</html>
