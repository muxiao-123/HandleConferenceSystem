<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>提交投票</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js"></script>
		<script type="text/javascript">
		//动态显示投票项
			$(function(){
			var select3= $("#select3").text();
			var select4= $("#select4").text();
			if(select3.length==0){
				$("#select33").addClass("hidden");
				}
			if(select4.length==0){
				$("#select44").addClass("hidden");
			}
		})
		</script>
		<style>
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
		
		
		
		<!--把投票选项发送给参会人员，然后后台实时统计投票数，和参与人数-->
		<div style="padding:10px;"></div>
		<div class="container " id="div11">
			<div class="row col-xs-10 col-xs-offset-1 ">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color:rgba(247,238,214,0.4);">
						<h4>当前位置&gt;参与投票</h4>
					</div>
					<div class="panel-body">
					<c:forEach items="${list_vote_message}" var="vote">
						<form action="uuuu" class="form-horizontal" method="post" >
							<div class="form-group well hidden">
								<label class="control-label col-md-3">投票id:</label>
                                <div class="col-md-6" >
                                	<input type="text"   value="${vote.vid }" class="form-control" name="vid"/>
                                </div>								
							</div>
							<div class="form-group well">
								<label class="control-label col-md-3">会议标题:</label>
								<p class=" col-offset-3 col-md-6">
								<span style="font-size:1.5em;color: rgba(255,255,255,1);"><strong>${vote.meet_title }</strong></span>
								</p>
                                <div class="col-md-6 hidden" >
                                	<input type="text"  value="${vote.meet_title }" class="form-control" name="meet_title" />
                                </div>								
							</div>
							
							<div class="form-group well">
								<label class="control-label col-md-3">投票内容:</label>
								<p class=" col-offset-3 col-md-6">
								<span style="font-size:1.5em;color: rgba(255,255,255,1);"><strong>${vote.vote_content }</strong></span>
								</p>
                                <div class="col-md-6 hidden" >
                                	<input type="text"  value="${vote.vote_content }" class="form-control" name="vote_content" />
                                </div>								
							</div>
							
							<!--
                            	作者：582775919@qq.com
                            	时间：2019-03-18
                            	描述：投票项循环输出
                            -->
							<div class="form-group well">
								<label class="control-label col-md-3">投票项:</label>
								<div class="col-md-6" style="font-size: 1.5em;">
									<input type="radio" style="width: 19px;height: 19px;" value="1" name="selectStatus" id="select1"  /><label>${vote.select1 }</label>
								</div>
							</div>
							
							<div class="form-group well">
								<label class="control-label col-md-3">投票项:</label>
								<div class="col-md-6" style="font-size: 1.5em;">
									<input type="radio" style="width: 19px;height: 19px;" value="2" name="selectStatus"  id="select2" /><label>${vote.select2 }</label>
								</div>
							</div>
							
							<div class="form-group well" id="select33">
								<label class="control-label col-md-3">投票项:</label>
								<div class="col-md-6" style="font-size: 1.5em;">
									<input type="radio" style="width: 19px;height: 19px;" value="3" name="selectStatus" id="select3" /><label id="select3">${vote.select3 }</label>
								</div>
							</div>
							<div class="form-group well " id="select44">
								<label class="control-label col-md-3">投票项:</label>
								<div class="col-md-6" style="font-size: 1.5em;">
									<input type="radio" style="width: 19px;height: 19px;" value="4" name="selectStatus" id="select4" /><label id="select4">${vote.select4 }</label>
								</div>
							</div>
							
							
							<div class=" col-md-offset-3 col-md-6">
								<button class="btn btn-success " id="toupiao1"  >提交投票</button>
						    </div>
							
						</form>
				</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div id="sds"></div>
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