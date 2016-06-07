<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/userLoginCheck.js" charset=utf-8></script>

<link rel="stylesheet" type="text/css" href="css/table_style.css" />
<link rel="stylesheet" type="text/css" href="css/style2.css"
	title="Origo" media="all" />
<title>Origo v1.1</title>
</head>

<body class="light blue smaller freestyle01">
	<div id="layout">
		<div id="row">
			<div class="col c7 aligncenter">
				<img src="images/logo.jpg" height="100" alt="" />
			</div>
			<div class="row">
				<p>
					<s:if test="#session.get('loginName') != null">
						&nbsp;&nbsp;<a href="#" class="tc">切换用户</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href=""><s:property value="#session.get('loginName')"/></a>,欢迎您
					</s:if>
					<s:elseif test="#session.get('loginName') == null">
						&nbsp;&nbsp;<a href="#" class="tc">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</s:elseif>
				</p>
			</div>

			<div id="gray"></div>

			<div class="popup" id="popup">

				<div class="top_nav" id='top_nav'>
					<div align="center">
						<i></i> <span>登录账号</span> <a class="guanbi"></a>
					</div>
				</div>
				<div id="min">
					<div class="tc_login">
						<div class="left">
							</br> </br>
							<div align="center">
								<img src="images/zfb_2yuan.jpg" width="387" height="93" />
							</div>
						</div>
						<div id="right">
							<s:form method="post" name="form_login" target="_top"
								namespace="/" action="/login!login.action"
								onsubmit="return register();">
								<i class="icon-mobile-phone"></i>
								<p id="namets"
									style="width: 120px; height: 12px;  font-size: 12px;"></p>
								<s:textfield name="name" id="uName" placeholder="用户名"
									onblur="return checkname()" cssClass="input_yh"></s:textfield>
								<s:password name="pwd" id="uPass" placeholder="密码"
									onblur="return checkpass();" cssClass="input_mm"></s:password>
								<s:radio name="selected" list="#{'1':'用户','0':'管理员'}" value="1"></s:radio>

								<!-- 	</div> -->
								<s:submit cssClass="loginBtn" title="Sign In" value="登录"></s:submit>
							</s:form>
							<dd>
								<div align="center">
									<a href="#" target="_blank">立即注册 </a>
								</div>
							</dd>
							<hr align="center" />

						</div>

					</div>

				</div>

			</div>


			<script type="text/javascript">
				//窗口效果
				//点击登录class为tc 显示
				$(".tc").click(function() {
					$("#gray").show();
					$("#popup").show();//查找ID为popup的DIV show()显示#gray
					tc_center();
				});
				//点击关闭按钮
				$("a.guanbi").click(function() {
					$("#gray").hide();
					$("#popup").hide();//查找ID为popup的DIV hide()隐藏
				});

				//窗口水平居中
				$(window).resize(function() {
					tc_center();
				});

				function tc_center() {
					var _top = ($(window).height() - $(".popup").height()) / 2;
					var _left = ($(window).width() - $(".popup").width()) / 2;

					$(".popup").css({
						top : _top,
						left : _left
					});
				}

				
			</script>

			<script type="text/javascript">
				$(document).ready(function() {

					$(".top_nav").mousedown(function(e) {
						$(this).css("cursor", "move");//改变鼠标指针的形状 
						var offset = $(this).offset();//DIV在页面的位置 
						var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离 
						var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离 
						$(document).bind("mousemove", function(ev) {
							//绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件 

							$(".popup").stop();//加上这个之后 

							var _x = ev.pageX - x;//获得X轴方向移动的值 
							var _y = ev.pageY - y;//获得Y轴方向移动的值 

							$(".popup").animate({
								left : _x + "px",
								top : _y + "px"
							}, 10);
						});

					});

					$(document).mouseup(function() {
						$(".popup").css("cursor", "default");
						$(this).unbind("mousemove");
					});
				});
			</script>
			<br /> <br />
			<!-- 搜索  -->
			<div class="row">
				<s:form>
					<s:submit theme="simple" cssClass="button" placeholder="搜索图书" value="308一下"></s:submit>
					<s:textfield theme="simple"></s:textfield>
				</s:form>
			</div>




			<div class="row">
				<div class="col c12 aligncenter">
					<img src="images/front1.jpg" width="960" height="240" alt="" />
				</div>
			</div>
			<!-- 左侧导航栏 -->
			<div class="row">
				<div class="col c2 alignleft">
					<ul class="menu">
						<!-- 管理员 -->
						<s:if test="#session.get('loginName') == '123456' ">
							<li><a href="home.jsp">首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
							<li><a href="#">图书归还管理</a></li>
							<li><a href="#">图书分类管理</a></li>
							<li><a href="#">图书信息管理</a></li>
							<li><a href="user_manager.jsp">会员信息管理</a></li>
							<li><a href="#">个人信息修改</a></li>
						</s:if>
						<!-- 普通用户 -->
						<s:if test="#session.get('loginName') != null && #session.get('loginName') != '123456'">
							<li><a href="home.jsp">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
							<li><a href="">图书查询</a></li>
							<li><a href="#">图书借阅</a></li>
							<li><a href="#">图书预定</a></li>
							<li><a href="#">信息修改</a></li>
						</s:if>
						<!-- 游客 -->
						<s:if test="#session.get('loginName') == null">
							<li><a href="home.jsp">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
							<li><a href="register.jsp">注&nbsp;&nbsp;&nbsp;&nbsp;册</a></li>
							<li><a href="#">图书查询</a></li>
						</s:if>
					</ul>
				</div>

				<div class="col c8_table">
					<div class="div_title">
						<b>
							会员信息管理 
						</b>
						<a class="a_head">注册新的会员</a>
					</div>

					<table id="table" cellspacing="0">
						<tr>
							<th>用户ID</th>
							<th>用户名</th>
							<th>联系方式</th>
							<th>基本操作</th>
						</tr>
						<tr>
							<td>Look at Orman's</td>
							<td>100%</td>
							<td>No</td>
							<td><a>编辑 </a><a style="color:red;margin-left: 7px;">删除</a></td>
					
					</table>
				
					<div class="div_bottom"></div>
				</div>

				<div class="col c2">
					<h3>Presentation:</h3>
					<p>
						This is the <a href="http://www.cssmoban.com/">Origo</a> template,
						with the basic layout from the <a
							href="http://www.cssmoban.com/templates/andreas01/">andreas01</a>
						template and the code base from <a
							href="http://www.cssmoban.com/templates/freestyle/">Freestyle</a>.
					</p>

					<h3>Links:</h3>
					<p>
						<a href="#">Sample link 1</a><br /> <a href="#">Sample link 2</a><br />
						<a href="#">Sample link 3</a>
					</p>
				</div>
			</div>

			<div id="footer" class="row">
				<div class="col c12 aligncenter">
					<h3>&copy; 2012 Your Name</h3>
					<p>
						<a href="http://www.cssmoban.com/">Template design</a> by <a
							href="http://www.cssmoban.com/">Andreas Viklund</a><br /> More
						Templates <a href="http://www.cssmoban.com/" target="_blank"
							title="模板之家">模板之家</a>
					</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>