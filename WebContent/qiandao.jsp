<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>签到页面</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/color.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js" ></script>
	</head>
	<body>
		<nav class="nav navbar-default navbar-fixed-top " role="navatigation">
			<div class="container-fluid col-xs-12 col-sm-12 col-md-12">
				<div class="navbar-header">
					<a href="#" class="navbar-brand ">
						<img src="img/会议logo3.png" style="height:60px;margin-top: -15px;" alt="logo" />
					</a>
					<button type="button" class="navbar-toggle  collapsed" data-toggle="collapse" data-target="#collapseNav">
							<span class="sr-only">toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
				</div>
				<div class="collapse navbar-collapse" id="collapseNav">
					<ul class="nav navbar-nav nav-tabs">
						<li >
							<a href="index1.jsp">首页</a>
						</li>
						<li>
							<a href="huiyizhongxin.jsp">会议中心</a>
						</li>
						<li>
							<a href="bangzhuzhongxin1.html">帮助中心</a>
						</li>
						<li class="active">
							<a href="yuhuiban.jsp">用户中心</a>
						</li>
						<li>
							<a href="pppp?currentPage=1">退出登陆</a>
						</li>
					</ul>
					
					<form class="navbar-form navbar-right hidden-xs" role="search">
						<button class="btn btn-success">欢迎${att.getUserName() }</button>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="搜索" />
							<button class="btn btn-primary">前进</button>
						</div>
					</form>
				</div>
			</div>
		</nav>
		
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
                    <a href="messageManage.jsp"><i class="glyphicon glyphicon-bell"></i> 收件箱</a>
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
		
		<div style="padding: 30px;"></div>
		
		<!--/*签到模块*/-->
		<div class="container" id="div11">
			<div class="row">
				<div class=" col-md-offset-2 col-md-7">
				<div class="panel panel-success">
					<div class="panel-heading ">
						<div class="col-xs-offset-4 col-md-offset-4">
							<h2>用户签到</h2>
						</div>
						
					</div>
					<div class="panel-body">
						<form action="xxxx" class="form-horizontal" method="post" >
						<div class="form-group">
							<label class="control-label col-md-3">会议标题:</label>
							<div class="col-md-6">
								<input type="text" required autofocus class="form-control" placeholder="请输入您所参加的会议" name="meet_title" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">您的姓名:</label>
							<div class="col-md-6">
								<input type="text" required  class="form-control" placeholder="请输入您的姓名" name="a_userName" />
							</div>
						</div>
						<div class="form-group">
							    <label class="control-label col-md-3"></label>
							<div class="col-md-6 ">
							    <input type="submit" class="btn btn-primary" value="签到" />
							</div>
						</div>
					</form>
					</div>
					<div class="panel-footer">
						<div class="col-xs-offset-4 col-md-offset-4">
							<h3>感谢来参会</h3>
						</div>
					</div>
						
					
				</div>
			    </div>
			</div>
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