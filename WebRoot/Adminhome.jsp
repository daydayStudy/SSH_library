<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@taglib prefix="s" uri="/struts-tags"%> <%
 	String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 			+ request.getServerName() + ":" + request.getServerPort()
 			+ path + "/";

 	//<!--  required="required" placeholder="用户名" autocomplete="off"  -->
 %> <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/userLoginCheck.js" charset="UTF-8"></script>
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
					<a href="#" class="tc">登录</a>
				</p>
			</div>

			<div id="gray"></div>

			<div class="popup" id="popup">

				<div class="top_nav" id="top_nav">
					<div align="center">
						<i></i> <span>登录账号</span> <a class="guanbi"></a>
					</div>
				</div>

				<div class="min">
					<div class="tc_login">
						<div class="left">
							</br> </br>
							<div align="center">
								<img src="images/zfb_2yuan.jpg" width="387" height="93" />
							</div>
						</div>
						<div id="right">
							<s:form method="POST" name="form_login" target="_top"
								onsubmit="return register();">
								<!-- <div align="center"> -->
								<i class="icon-mobile-phone"></i>
								<p id="namets"
									style="width: 150px; height: 12px;  font-size: 12px;"></p>
								<s:textfield name="name" id="uName" placeholder="用户名"
									onblur="return checkname()" cssClass="loginInp"></s:textfield>
								<s:password name="pass" id="uPass" placeholder="密码"
									onblur="return checkpass();" cssClass="loginInp"></s:password>
								<s:radio name="checkUser" list="#{'1':'管理员','0':'用户'}" value="0"></s:radio>

								<!-- 	</div> -->
								<div align="center">
									<s:submit cssClass="loginBtn" title="Sign In" value="登录"></s:submit>
								</div>
							</s:form>
							<dd>
								<div align="center">
									<a href="register.jsp" target="_blank">立即注册 </a>
								</div>
							</dd>
							

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
				})

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
				})
			</script>
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
						<li><a href="sSelect.action">图书添加</a></li>
					</ul>
				</div>

				<div class="col c8">
					<h2>Lorem Ipsum</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
						sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
						Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in
						reprehenderit in voluptate velit esse cillum dolore eu fugiat
						nulla pariatur. Excepteur sint occaecat cupidatat non proident,
						sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

					<h3>Dolor Sit Amet</h3>
					<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
						laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure
						dolor in reprehenderit in voluptate velit esse cillum dolore eu
						fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est
						laborum.</p>
					
					
				</div>

				<div class="col c2">
					<h3>Introdution:</h3>
					<p>
						308图书馆，随时随地上网查阅图书，舒适环境，温馨格调，只有你，值得拥有！
					</p>

					<h3>Notes:</h3>
					<p>
						<a href="#">Search whatever you want</a><br /> 
						<a href="#">Read wherever you want</a><br />
					</p>
				</div>
			</div>

			<div id="footer" class="row">
				<div class="col c12 aligncenter">
					<h3>&copy; 2016 308图书馆</h3>
					<p>
						<a href="">许锋</a> <a
							href="">陈俊聪</a> 制作<br /> 北理珠
						37栋 <a style="" href="" target="_blank"
							title="模板之家">308工作室</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
	</html> 