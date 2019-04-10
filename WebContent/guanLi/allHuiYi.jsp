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
		<style type="text/css">
		   .lili{
		      background-color:rgba(255,255,255,0.5);
		   }
			.nav-tabs{
			    border-bottom:0px;
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
								<a href="allHuiYi.jsp">会议</a>
							</li>
							<li>
								<a href="admin.jsp">用户</a>
							</li>
							<li>
							<a href="../pppp?currentPage=1">退出登陆</a>
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
							<p class="navbar-text">
								欢迎您-<a href="#" class="navbar-link">${admin.getName()}</a>
							</p>
						</div>
					</div>
				</div>
			    </nav>
		    </div>
	    </div>
		<div class="container" >
			<div class="row col-md-12">
			<div style="padding:20px"></div>
				<div class="table-responsive ">
					<table class="table table-striped table-bordered ">
						<thead>
							<tr class="p"><td colspan="10">当前位置&gt;所有会议</td></tr>
							<tr class="info"><td colspan="10">所有会议</td></tr>
							<tr class="danger">
								<td>会议标题</td>
								<td>会议概况</td>
								<td>会议主办方</td>
								<td>会议地点</td>
								<td>会议主持人</td>
								<td>会议开始时间</td>
								<td>会议发起者id</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list_m }" var="list_m">
							<tr>
								<td>${list_m.meet_title}</td>
								<td>${list_m.meet_points}</td>
								<td>${list_m.sponsor}</td>
								<td>${list_m.address}</td>
								<td>${list_m.toastMaster}</td>
								<td>${list_m.startDate}</td>
								<td>${list_m.oid}</td>
								<td><button class="btn btn-default">删除</button></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
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
