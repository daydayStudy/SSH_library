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
<script type="text/javascript" src="js/BorrowCheck.js" charset=utf-8></script>

<link rel="stylesheet" type="text/css" href="css/table_style.css" />
<link rel="stylesheet" type="text/css" href="css/style2.css"
	title="Origo" media="all" />
<title>Origo v1.1</title>
</head>

<body class="light blue smaller freestyle01" onload="currentTime()">
	<div id="layout">
		<div id="row">
			<div class="col c7 aligncenter">
				<img src="images/logo.jpg" height="100" alt="" />
			</div>
			<div class="row">
				<p>
					<s:if test="#session.get('loginName') != null">
						&nbsp;&nbsp;<a href="#" class="tc">切换用户</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href=""><s:property value="#session.get('loginName')" /></a>,欢迎您
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
								<img style="margin-top: 8px;" src="images/zfb_2yuan.jpg" width="387" height="93" />
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
								<s:radio name="selected" list="#{'1':'用户','0':'管理员'}" value="1"
									cssStyle="margin-left:10px; margin-top:8px;margin-bottom:8px;"></s:radio>

								<s:submit cssClass="loginBtn" title="Sign In" value="登录"></s:submit>
							</s:form>
							<dd>
								<div align="center">
									<a href="register.jsp" target="_blank" class="a_register">立即注册 </a>
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
				function deleteConfirm(ids) {
					if(confirm('确定删除？')){
						$.ajax({
							type : "post",
							url : "userManager.action",
							dataType:"json",
							data : {method:"delete",id:ids},
						});
				    }else {
				    	return false;
				    }
				}
				
				function changeColor() {
					var name = '${bookName}';
					var ff = document.getElementById("td_name").innerHTML;
					document.getElementById("td_name").innerHTML = ff.replace(
					name, "<font color='red'>"+name+"</font>");
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
				function currentTime() {
					var time = new Date(); //获得当前时间
					var year = time.getFullYear();//获得年、月、日
					var month = time.getMonth()+1;
					var day = time.getDate(); 
					document.getElementById("order_date").value=year+"-"+month+"-"+day;
				}
			</script>
			<br /> <br />
			<!-- 搜索  -->
			<div class="row">
				<s:form action="/selectBook">
					<s:submit theme="simple" cssClass="button" 
						value="308一下"></s:submit>
					<s:textfield name="bookname" theme="simple" placeholder="搜索图书"></s:textfield>
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
							<li><a href="btypeManager.action">图书类别管理</a></li>
							<li><a href="bookManager.action">图书信息管理</a></li>
							<li><a href="borrow_book.jsp">图书借阅管理</a></li>
							<li><a href="userManager.action">会员信息管理</a></li>
							<li><a id="select" href="sladmin.action?method=select&id=<s:property value="#session.get('loginName')"/>">个人信息修改</a></li>
						</s:if>
						<!-- 普通用户 -->
						<s:if
							test="#session.get('loginName') != null && #session.get('loginName') != '123456'">
							<li><a href="home.jsp">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
							<li><a href="selectBook.action">图书查询</a></li>
							<li><a href="borrowRecord.action">借阅记录</a></li>
							<li><a href="orderRecord.action">预定记录</a></li>
							<li><a id="select" href="slreader.action?method=select&id=<s:property value="#session.get('loginName')"/>">信息修改</a></li>
						</s:if>
						<!-- 游客 -->
						<s:if test="#session.get('loginName') == null">
							<li><a href="home.jsp">首&nbsp;&nbsp;&nbsp;&nbsp;页</a></li>
							<li><a href="register.jsp">注&nbsp;&nbsp;&nbsp;&nbsp;册</a></li>
							<li><a href="selectBook.action">图书查询</a></li>
						</s:if>
					</ul>
				</div>

				<div class="col c8_table">
					<div class="div_title">
						<b> 罚款</b>
						<div id="div_borrow_info">
							<s:form name="orderrecordinfo" method="post" namespace="/" onsubmit="return checkOrderNumber();">
								<font class="font_style">用户ID:</font>
								<s:textfield theme="simple" name="readerID" readonly="true" placeholder="用户ID" cssClass="order" 
								value="%{#request.bean.rederid}"></s:textfield>
								<font class="font_style">罚款日期:</font>
								<s:textfield theme="simple" name="borrowdate" cssClass="order" readonly="true" id="order_date"></s:textfield>
								<br/>
								<font class="font_style">图书名:</font>
								<s:textfield theme="simple" name="booktype" cssClass="order" readonly="true"
								value="%{#request.bean.bookname}"></s:textfield>
								<font class="font_style">罚款金额:</font>
								<s:textfield theme="simple" name="fines" cssClass="order" readonly="true"
								value="%{#request.fine}"></s:textfield>
								<br/>
								
								<s:hidden name="amount" value="%{#request.bean.amount}"></s:hidden>
								<s:hidden name="isbn" value="%{#request.bean.isbn}"></s:hidden>
								<s:hidden name="borrowid" value="%{#request.bean.borrowid}"></s:hidden>
								
								<font id="orderTips"
									style="width:120px; height: 30px;font-size: 15px;margin-left: 34px;color:red;"></font>
								<s:submit theme="simple" cssClass="borrow_button" value="确定" cssStyle="float:right;margin-right:35px;" onclick="orderRecord()"></s:submit>
							</s:form>
						</div>
					</div>
					<div class="div_bottom">
					</div>
				</div>
				<script type="text/javascript">
				function orderRecord() {
					document.orderrecordinfo.action = "/library/fineMoney!doFineMoney.action";
					document.orderrecordinfo.submit();
				}
				</script>

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
