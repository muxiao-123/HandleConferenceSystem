<%@page language="java" contentType="text/html;chatset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>会议详情</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<style>
			.well{
				background-color:white;
				padding: 10px;
			}
			.jumbotron{
				background-color: rgba(193,210,240,0.5);
			}
		</style>
		<!-- 游客版 -->
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
								<a href="index.jsp">首页</a>
							</li>
							<li>
								<a href="#">会议中心</a>
							</li>
						</ul>
						<a href="bangzhuzhongxin1.html" class="btn btn-primary btn-sm navbar-btn navbar-right hidden-xs">联系我们</a>
						<div class="profile navbar-right">
						    <ul class="nav navbar-nav">
								<li class=""><a href="Login.html">登陆</a></li>
								<li><a href="Register.jsp">注册</a></li>
							</ul>
							<p class="navbar-text">
								欢迎您-<a href="#" class="navbar-link">${att.getUserName()}</a>
							</p>
						</div>
					</div>
				</div>
			    </nav>
		    </div>
	    </div>
		
        <div style="padding: 10px;"></div>
		
		<div class="container" id="div11">
		
	        <div class="col-md-8 col-md-offset-2">
			</div>
			<div class="jumbotron col-md-8 col-md-offset-2">
			 	<ul class="nav nav-pills">
			 		<li><a href="#huiyijieshao" style="font-size: 14px;">会议介绍</a></li>
			 		<li><a href="#huiyiyicheng" style="font-size: 14px;">会议议程</a></li>
			 		<li><a href="#yanjiangjiabin" style="font-size: 14px;">演讲嘉宾</a></li>
			 		<li><a href="#huiyidizhi" style="font-size: 14px;">会议地址</a></li>
			 	</ul>
			 	<div class="well">
			 		<div class="page-header" id="huiyijieshao" style="font-size: 16px;">
			 			<span class="glyphicon glyphicon-bullhorn" style="color: #28A4C9; font-size: 25px;"></span>
			 			&nbsp;会议介绍
			 		</div>
				 	<div>
				 		<div class="media">
				 		<div class="media-left">
				 				<img src="img/91.jpg" class="media-object" alt="dsdj"/>
				 		</div>
				 			<div class="media-body">
				 				<h4 class="media-heading">${meet3.getMeet_title() }</h4>
				 				<p style="font-size: 1.1em;">${meet3.getMeet_points()}</p>
				 			</div>
				 	    </div>
				 	</div>
			 	    <hr />
			 	   <div>
			 	   	 <h3 style="text-align: center;color: #5BC0DE; font-size: 1.5em;"><strong>${meet3.getMeet_title() }</strong></h3>
			 	    <p style="font-size: 1.1em;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${meet3.getMeetInfo()}
			 	    </p>
			 	   </div>
		 	    </div>
		 	    
			 	<div class="well" >
				 	<div class="page-header" id="huiyiyicheng" style="font-size: 15px;">
				 		<span class="glyphicon glyphicon-list-alt" style="color: #28A4C9; font-size: 25px;">
				 		</span>
				 		会议议程
				 	</div>
				 	<p style="font-size: 1.1em;">会议时间:${meet3.getStartDate()}--${meet3.getEndDate()}</p>
				</div>
				 	
			 	<div class="well" >
			 		<div class="page-header" id="yanjiangjiabin" style="font-size: 15px;">
			 			<span class="glyphicon glyphicon-user" style="color: #28A4C9; font-size: 25px;"></span>
			 			主持人
			 		</div>
			 			
			 		<div class="media">
			 			<div class="media-left">
			 				<img src="img/91.jpg" class="media-object" alt="木箫" />
			 			</div>
			 			<div class="media-body">
			 				<h4 class="media-heading">${ meet3.getToastMaster()}</h4>
			 				<p style="font-size: 1.1em;">主讲内容：${meet3.getMeet_points()}</p>
			 			</div>
			 		</div>
			 		
			 	</div>
			 	
			 	<div class="well" >
			 		<div class="page-header" id="huiyidizhi" style="font-size: 15px;">
			 			<span class="glyphicon glyphicon-hand-right" style="color:#28A4C9; font-size: 25px;"></span>
			 				会议地址</div>
			 		<p style="font-size: 1.1em;">${meet3.getAddress()}</p>
			 	</div>
			 	<div class="well">
			 		<button class="btn btn-primary" id="button1"> 报名参会</button>
			 		<a href="javascript:void();" class="btn btn-success"> 会刊链接</a>
			 	</div>
			 	
			 	<div class="col-md-5 col-md-offset-1 hidden" id="baoMing">
			 		<div style="background-color: rgba(96,96,96,0.1)">
			 			<form class="form-horizontal">
			 				<!--保证获取id-->
			 				<div class="hidden">
			 					<input type="text" placeholder="会议id从当前信息页面获" />
			 					<input type="text" placeholder="用户id从session获得" />
			 				</div>
			 				
			 				<div class="form-group">
			 				    <label class="control-label">您的姓名</label>
			 				<div >
			 					<input type="text" required autofocus placeholder="请输入您的姓名" class="form-control" />
			 				</div>
			 				</div>
			 				
			 				<div class="form-group">
			 					<label class="control-label">您的邮箱</label>
			 					<div class="">
			 						<input type="email" required class="form-control" />
			 					</div>
			 				</div>
			 				
			 				<div class="form-group">
			 					<input type="submit" class="btn btn-default" value="确定报名" class="form-control" />
			 				</div>
			 				
			 			</form>
			 			
			 		</div>
			 	</div>
			 	
			</div>
		</div>
		<div class="col-md-9 col-md-offset-2">
			
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