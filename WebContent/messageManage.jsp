<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>收件箱页面</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js" ></script>
		<script type="text/javascript" src="js/donghua.js"></script>
		<style type="text/css">
		
		.panel{
		  background-color:transparent;
		}
		</style>
	</head>
	<body id="beijing">
		<div class="container" >
			<div class="col-md-12 ">
				<div style="padding: 10px;"></div>
				<nav class="nav navbar-inverse  col-md-12" role="navatigation">
				<div class="container-fluid col-xs-12 col-sm-12 col-md-12">
					<div class="navbar-header">
						<a href="#" class="navbar-brand ">
							<img src="img/会议logo3.png" style="height:60px;margin-top: -15px;" alt="logo" />
						</a>
						<button type="button" class="navbar-toggle  collapsed" data-toggle="collapse" data-target="#collapseNav" style="background-color: rgb(0,191,255);border:none ;">
								<span class="sr-only">toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
						</button>
					</div>
					<div class="collapse navbar-collapse" id="collapseNav">
						<ul class="nav navbar-nav nav-pills">
							<li >
								<a href="index1.jsp">首页</a>
							</li>
							<li>
								<a href="#">会议中心</a>
							</li>
							<li class="active">
								<a href="yuhuiban.jsp">用户中心</a>
							</li>
							<li>
								<a href="pppp?currentPage=1">退出登陆</a>
							</li>
							
						</ul>
						<a href="bangzhuzhongxin1.html" class="btn btn-primary btn-sm navbar-btn navbar-right hidden-xs">联系我们</a>
						<div class="profile navbar-right">
							<p class="navbar-text">
								欢迎您-<a href="#" class="navbar-link">${att.getUserName()}</a>
							</p>
						</div>
					</div>
				</div>
			    </nav>
		    </div>
	    </div>
		
		
		<div style="padding:10px;"></div>
		<div class="container" id="div11">
			<div class="row">
				<div class="col-md-offset-1">
					<div class="col-md-11">
						<div class="panel panel-success">
							<div class="panel-heading">
								收件箱
							</div>
							<div class="panel-body"><!--/*加动态数据*/-->
							
								<c:forEach items="${list_a_message }" var="message">
								<div class="well col-md-4">
									<p class="pull-right" style="margin-left: 20px;">
										<button class="btn btn-default">删除</button>
									</p>
									<p>来自：${message.meetTitle }</p>
									<p>时间：${message.sendTime }</p>
									<p>内容： ${message.messageContent}</p>
								</div>
								</c:forEach>
								
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div id="wrapper">
        <div class="overlay"></div>
        <!-- Sidebar -->
        <nav class="navbar navbar-default navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <li>
                    <a href="index1.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a>
                </li>
                <li>
                    <a href="iiii"><span class="glyphicon glyphicon-list-alt"></span> 我的会议</a>
                </li>
                <li>
                    <a href="qiandao.jsp"><i class="glyphicon glyphicon-hand-right"></i> 签到</a>
                </li>
                <li>
                    <a href="qqqq"><i class="glyphicon glyphicon-bell"></i> 收件箱</a>
                </li>
                <li>
                    <a href="yonghuxinxi.jsp"><span class="glyphicon glyphicon-cog"></span> 信息管理</a>
                </li>
            </ul>
        </nav>
        <!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
          <button type="button" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas">
            <span class="hamb-top"></span>
            <span class="hamb-middle"></span>
            <span class="hamb-bottom"></span>
          </button>
        </div>
        <!-- /#page-content-wrapper -->
        </div>
		
		<footer class="container-fluid foot-wrap col-xs-12 " style="background-color:#DCDCDC;">
		<!--	页尾-->
		<!--<div style="padding: 1px;"></div><br />-->
			<div class="text-justify">
			 <div class=" col-xs-5 col-md-2 col-md-offset-3">
				<h4>地址:</h4>
				<p>广东省韶关市xx路</p>
			 </div>
			 <div class="col-md-2 col-xs-5">
				<h4>邮箱:</h4>
				<p>1111111@qq.com</p>
			 </div>
			 <div class="col-md-2 col-xs-5">
				<h4>电话:</h4>
				<p>13414242144</p>
			 </div>   
			 </div>
			<div class=" col-xs-12 col-md-12">
				<p align="center" style="margin-top: 5px;color:#878B91;">
				Copyright &copy;2018 Dreyer
				</p>
			</div>
		</footer>
	</body>
</html>