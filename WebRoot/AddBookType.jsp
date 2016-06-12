<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<jsp:useBean id="admin" scope="page" class="com.library.bean.Admin" />
<jsp:setProperty name="admin" property="name" />

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
<script type="text/javascript" src="js/AddbookTypeCheck.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="css/style.css"
	title="Origo" media="all">
<title>Origo v1.1</title>
</head>

<body class="light blue smaller freestyle01">
	<div id="layout">


		<div id="row">
			<div class="col c7 alignleft">
				<img src="images/logo.jpg" height="100" alt="">
			</div>
			<a name="top"></a>
			<div class="row">
				<p>
					<a href="#"><%=admin.getName()%></a>
				</p>
			</div>


			<br> <br>
			<!-- 搜索  -->
			<div class="row">
				<s:form>
					<s:submit theme="simple" cssClass="button" value="308一下"></s:submit>
					<s:textfield theme="simple"></s:textfield>
				</s:form>
			</div>




			<div class="row">
				<div class="col c12 aligncenter">
					<img src="images/front1.jpg" width="960" height="240" alt="">
				</div>
			</div>
			<div class="row">
				<div class="col c2 alignleft">
					<ul class="menu">
						<li><a href="#">首页</a></li>
						<li><a href="#">图书分类</a></li>
					</ul>
				</div>

				<div class="col c8">
					<center>
						<s:form action="addbooktype" method="post" namespace="/"
							onsubmit="return addbooktyck();">
							<p id="namets"
								style="width: 150px; height: 12px;  font-size: 12px;"></p>
							</br>
														
																							
							<s:textfield label="类型名称" name="booktype.typename" id="Tname"
								placeholder="类型名称" onblur="return checkbname()" cssClass="loginInp"></s:textfield>
							
							<s:textfield label="罚款金额" name="booktype.finemoney" id="Tprice"
								placeholder="罚款金额" onblur="return checkprice()"
								cssClass="loginInp"></s:textfield>
							<s:textfield label="可借天数" name="booktype.days" id="Tday"
								placeholder="可借天数" onblur="return checkday()"
								cssClass="loginInp"></s:textfield>
							

							<s:submit cssClass="loginBtn" title="Sign In" value="图书添加"></s:submit>

						</s:form>
					</center>
                   
				</div>


				<div class="col c2">
					<h3>308图书馆</h3>
					<p>不知道借什么书？上308图书馆308一下，你就知道</p>
					<p>借书之后，老是忘记自己归还日期？上308图书馆，你就知道</p>
					<p>还书手续太麻烦？上308图书馆，只需一个按钮</p>
					<p>308图书馆，随时随地上网查阅图书，舒适环境，温馨格调，只有你，值得拥有。</p>
				</div>
			</div>

			<a href="#top"
				style="display:block; width:35px; height:42px; 
  position:fixed; right:20px; bottom:20px;"><img
				src="images/top.gif"></a>
			<div id="footer" class="row">
				<div class="col c12 aligncenter">
					<h3>&copy; 2012 Your Name</h3>
					<p>
						<a href="http://www.cssmoban.com/">Template design</a> by <a
							href="http://www.cssmoban.com/">Andreas Viklund</a><br> More
						Templates <a href="http://www.cssmoban.com/" target="_blank"
							title="模板之家">22</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
