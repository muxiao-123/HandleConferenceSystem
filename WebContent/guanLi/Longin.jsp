<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/Nav.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="../js/bootstrap.min.js" ></script>
        <style>
          .panel{
             background-color:rgba(0,191,255,0.5);
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
							<img src="../img/会议logo3.png" style="height:60px;margin-top: -15px;" alt="logo" />
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
							<li class="active">
								<a href="../index.jsp">首页</a>
							</li>
							<li>
								<a href="#">会议中心</a>
							</li>
						</ul>
						<form class="navbar-form navbar-left hidden-xs" role="search">
							<div class="form-group">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="搜索" name="text1" style="height: 36px;"/>
								     <button type="submit" class="input-group-addon" style="background-color: transparent;">
								     	<span class="glyphicon glyphicon-search"style="font-size: 1.5em;"></span>
								     </button>
								</div>
							</div>
						</form>
						<a href="bangzhuzhongxin.html" class="btn btn-primary btn-sm navbar-btn navbar-right hidden-xs">联系我们</a>
						<div class="profile navbar-right">
						    <ul class="nav navbar-nav">
								<li><a href="Login.jsp">登陆</a></li>
								<li><a href="#">注册</a></li>
							</ul>
							<p class="navbar-text">
								欢迎您-<a href="#" class="navbar-link"></a>
							</p>
						</div>
					</div>
				</div>
			    </nav>
		    </div>
	    </div>
		<div>
		
        <div class="container" id="div11">
        	<div class="row">
        		<div class="col-xs-offset-2 col-xs-8 col-md-6 col-md-offset-6" style="padding-top: 20px;">
        		<div class="panel panel-warning" >
        			<div class="panel-heading">
        					<h4><span class="glyphicon glyphicon-user" style="color:rgba(0,0,0,0.5)">&nbsp;管理员登陆</span></h4>
        			</div>
        			<div class="panel-body">
                                  <!--
                                  	登陆表单
                                  -->
						<form action="nmsl" method="post" class="form-horizontal" id="form-login" id="form1" name="form1">
							<div class="form-group">
								<div class="col-xs-10 col-xs-offset-1 col-md-6 col-md-offset-3">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
										<input type="text" autofocus="autofocus" required placeholder="用户名：" class="form-control" id="name" name="name" />	
										<!--参靠-->
									</div>
								</div>
							</div>
							<div class="form-group">
								    <div class="col-xs-10 col-xs-offset-1 col-md-6 col-md-offset-3">
								       <div class="input-group">
								       	<span class="input-group-addon"><span class="glyphicon glyphicon-eye-open"></span></span>
								       	<input type="password" required placeholder="请输入密码" class="form-control" id="pass" name="password"/>
								       </div>
								    </div>
							</div>
							<div class="form-group">
								<div class=" col-xs-offset-1 col-md-6 col-md-offset-3">
									<button class="btn btn-primary  col-xs-5 col-md-12" id="buttontj">登    录</button>
								</div>
							</div>
							<div class="form-group ">
								<div class="col-xs-offset-1 col-md-6 col-md-offset-3">
								    <span id="tishi" >${data}</span >
								</div>
							</div>
						</form>
						
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
			<p align="center" style="margin-top: 20px;color:#878B91;">
			Copyright &copy;2018 Dreyer
			</p>
		</div>
	</footer>
	</body>
</html>