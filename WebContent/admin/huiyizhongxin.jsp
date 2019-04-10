<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../css/bootstrap.min.css" />
		<link rel="stylesheet" href="../css/Nav.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="../js/bootstrap.min.js" ></script>
		<!--<script type="text/javascript" src="../js/zuoceguding.js" ></script>-->
		<style>
			.well{
				padding: 10px;
			}
		</style>
	</head>
	<body id="beijing">
		<!--如何使用户和非用户访问到会议详情-->
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
							<li >
								<a href="Myconference.jsp">首页</a>
							</li>
							<li class="active">
								<a href="Myconference.jsp">用户中心</a>
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
						<a href="bangzhuzhongxin.jsp" class="btn btn-primary btn-sm navbar-btn navbar-right hidden-xs">联系我们</a>
						<div class="profile navbar-right">
							<p class="navbar-text">
								欢迎您-<a href="#" class="navbar-link">${org.getO_userName()}</a>
							</p>
						</div>
					</div>
				</div>
			    </nav>
		    </div>
	    </div>
		
		<div style="padding: 32px;"></div>
		<!--会议信息-->
		<div class="container">
			<div class="row col-md-10 col-md-offset-1" style="border: 1px dotted #5BC0DE;border-top: 0px;">
				<div class="well col-xs-12 col-md-12">当前位置&gt;会议中心</div>
				<div class="thumbnail col-xs-12 col-md-4" id="div-huiyi">
					<img src="../img/1532747704381.jpg" / id="img-1">
					<h4><a href="huiyixiang.html" style="text-decoration: none;">木箫座谈会</a></h4>
					<span>2019/2/1</span><span>韶关</span>
				</div>
				
				<div class="thumbnail col-xs-12 col-md-4" id="div-huiyi">
					<img src="../img/1532747704381.jpg" / id="img-1">
					<h4><a href="#" style="text-decoration: none;">木箫座谈会</a></h4>
					<span>2019/2/1</span><span>韶关</span>
				</div>
				
				<div class="thumbnail col-xs-12 col-md-4" id="div-huiyi">
					<img src="../img/1532747704381.jpg" / id="img-1">
					<h4><a href="#" style="text-decoration: none;">木箫座谈会</a></h4>
					<span>2019/2/1</span><span>韶关</span>
				</div>
				
				<div class="thumbnail col-xs-12 col-md-4" id="div-huiyi">
					<img src="../img/1532747704381.jpg" / id="img-1">
					<h4><a href="#" style="text-decoration: none;">木箫座谈会</a></h4>
					<span>2019/2/1</span><span>韶关</span>
				</div>
				
				<div class="thumbnail col-xs-12 col-md-4" id="div-huiyi">
					<img src="../img/1532747704381.jpg" / id="img-1">
					<h4><a href="#" style="text-decoration: none;">木箫座谈会</a></h4>
					<span>2019/2/1</span><span>韶关</span>
				</div>
				
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