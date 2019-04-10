<%@page language="java" contentType="text/html;chatset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/color.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js" ></script>
		<script type="text/javascript" src="js/donghua.js"></script>
		<style>
			.well{
				padding: 10px;
			}
		</style>
	</head>
	<body>
		<!--如何使用户和非用户访问到会议详情-->
		<nav class="nav navbar-default navbar-fixed-top " role="navatigation">
			<div class="container-fluid  col-sm-12 col-md-12"><!--col-xs-9-->
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
						<li class="active">
							<a href="huiyizhongxin.jsp">会议中心</a>
						</li>
						<li>
							<a href="bangzhuzhongxin1.html">帮助中心</a>
						</li>
						<li >
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
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-lg-offset-2">
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
		
		<div style="padding: 5px;"></div>
		<!--会议信息-->
		<div class="container" id="div11">
			<div class="row col-md-10 col-md-offset-1" style="border: 1px dotted #5BC0DE;border-top: 0px;">
				<div class="well col-xs-12 col-md-12">当前位置&gt;会议中心</div>
					<c:forEach items="${list }" var="meet">
						<div class="thumbnail col-xs-12 col-md-4" id="div-huiyi">
							<img src="img/1532747704381.jpg" id="img-1">
							<h4><a href="huiyixiang.html" style="text-decoration: none;">木箫座谈会${meet.getMeet_title()}</a></h4>
							<span>2019/2/1</span><span>韶关${meet.getAddress()}</span>
						</div>
					</c:forEach>
			</div>
		</div>
		
		<!--分页设置-->
		
		<div class="container">
			<nav aria-label="page navigation" class="col-xs-offset-2 col-md-offset-4">
				<ul class="pagination ">
					<li><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
				</ul>
			</nav>
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
				<p align="center" style="margin-top: 20px;color:#878B91;">
				Copyright &copy;2018 Dreyer
				</p>
			</div>
	    </footer>
	</body>
</html>