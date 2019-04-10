<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js" ></script>
		<style>
		.panel{
		background-color:rgba(0,191,255,0.3);
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
		
		<div style="padding:10px;"></div>
		<!--问卷调查-->
		<!--先发送到服务器，然后服务器端判断有哪些用户参会，再把整块html内容发送给参会人员，参会人员填写完，
		提交后自动删除该页面，之后提交到服务器端，
		服务器端统计问卷调查人数，和所填内容，把数据发送到组织者，数据统计界面-->
		<div class="container " id="div11">
			<div class="row col-md-9 col-md-offset-2 ">
				<div class="panel panel-default ">
					<div class="panel-heading" style="background-color:rgba(247,238,214,0.7);">
						问卷调查&gt;满意度调查
					</div>
					<div class="panel-body">
						<form action="rrrr" method="post" class="form-horizontal">
						<!-- 问卷调查项，默认最多5个 -->
							<div class="form-group">
								<label class="control-label col-md-3">会议标题:</label>
								<div class="col-md-6">
									<input type="text" required class="form-control" placeholder="请输入会议标题" name="meet_title" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">问卷标题:</label>
								<div class="col-md-6">
									<input type="text" required class="form-control" placeholder="请输入问卷标题" name="wen_juan_theme" />
								</div>
							</div>
							<div class="form-group" >
								<label class="control-label col-md-3">问题一:</label>
								<div class="col-md-6">
									<input type="text" required class="form-control" placeholder="请输入问题一" name="wen_ti1" />
								<!--动态增加-->
								</div>
							</div>
							<div class="form-group" >
								<label class="control-label col-md-3">问题二:</label>
								<div class="col-md-6">
									<input type="text" required class="form-control" placeholder="请输入问题二" name="wen_ti2" />
								<!--动态增加-->
								</div>
							</div>
							<div class="form-group" >
								<label class="control-label col-md-3">问题三:</label>
								<div class="col-md-6">
									<input type="text" required class="form-control" placeholder="请输入问题三" name="wen_ti3" />
								<!--动态增加-->
								</div>
							</div>
							
							<div class="form-group" >
								<label class="control-label col-md-3">问题四:</label>
								<div class="col-md-6">
									<input type="text" class="form-control" placeholder="请输入问题四" name="wen_ti4" />
								<!--动态增加-->
								</div>
							</div>
							<div class="form-group" >
								<label class="control-label col-md-3">问题五:</label>
								<div class="col-md-6">
									<input type="text" class="form-control" placeholder="请输入问题五" name="wen_ti5" />
								<!--动态增加-->
								</div>
							</div>
							<div class=" col-md-offset-6 col-md-6">
								<button class="btn btn-success " id="toupiao1" >发起问卷</button>
								<button class="btn btn-warning" disabled="none">取消问卷</button>
						    </div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div id="wrapper">
        <div class="overlay"></div>
        <!-- Sidebar -->
        <nav class="navbar navbar-default navbar-fixed-top" id="sidebar-wrapper" role="navigation">
            <ul class="nav sidebar-nav">
                <!--<li class="sidebar-brand">
                    <a href="#">
                     用户中心
                    </a>
                </li>-->
                <li>
                    <a href="Myconference.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" aria-expanded="false" href="#" data-toggle="dropdown">
                  	<span class="glyphicon glyphicon-list-alt"></span> 我的会议 <span class="caret"></span>
                   </a>
                  <ul class="dropdown-menu" role="menu" >
                    <li class="dropdown-header"></li>
                    <li><a href="ffff">已发布会议</a></li>
                    <li><a href="fabuhuiyi.jsp">新建会议</a></li>
                  </ul>
                </li>
                <li>
                    <a href="wenjuandiaocha.jsp"><span class="glyphicon glyphicon-plus-sign"></span> 发起问卷调查</a>
                </li>
                <li>
                    <a href="choujiang.jsp"><span class="glyphicon glyphicon-gift"></span> 发起抽奖</a>
                </li>
              
                <li>
                    <a href="toupiao.jsp"><span class="glyphicon glyphicon-signal"></span> 发起投票</a>
                </li>
                <li>
                    <a href="qiandao.jsp"><span class="glyphicon glyphicon-hand-right"></span> 发起签到</a>
                </li>
                 <li>
                    <a href="qqqq"><span class="glyphicon glyphicon-pencil"></span> 发送消息</a>
                </li>
                 <li>
                    <a href="tongji.jsp"><span class="glyphicon glyphicon-stats"></span> 会议数据统计</a>
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
			<p align="center" style="margin-top: 20px;color:#878B91;">
			Copyright &copy;2018 Dreyer
			</p>
		</div>
	</footer>
	</body>
</html>