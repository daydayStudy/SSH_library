<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
		<s:form action="myregister"  method="post" namespace="/" onsubmit="return register1();">
			<p id="namets2"									
			style="width: 150px; height: 12px;  font-size: 12px;"></p>
			</br>
			<s:textfield label="用户名" name="reader.name" id="uName1" placeholder="用户名" 
				cssClass="input1" onblur="return checkname1()" ></s:textfield>
			<s:password label="密码" name="reader.pwd" id="uPass1" placeholder="密码"
				cssClass="input1" onblur="return checkpass1();" ></s:password>
			<s:textfield label="年龄" name="reader.age" id="uAge" placeholder="年龄"
				cssClass="input1" onblur="return checkage()" ></s:textfield>
			<s:radio name="reader.sex" list="#{'男':'男','女':'女'}" value="'男'" > </s:radio>
			<s:textfield label="联系方式" name="reader.tel" id="uTel" placeholder="联系方式"
				cssClass="input1" onblur="return checktel()" ></s:textfield>
			<s:textfield label="邮箱" name="reader.email" id="uEmail" placeholder="邮箱"
				cssClass="input1" onblur="return checkemail()" ></s:textfield>

			<s:submit cssClass="button1" title="Sign In" value="注册"></s:submit>

		</s:form>
</center>

	

</body>
</html>
