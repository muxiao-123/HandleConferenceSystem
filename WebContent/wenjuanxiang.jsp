<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<script type="text/javascript" src="js/zuoceguding.js"></script>
		<style>
		.well{
		background-color:rgba(0,191,255,0.5);
		}
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
                    <a href="qqqq"><i class="glyphicon glyphicon-bell"></i> 收件箱 <span class="badge " style="background-color: red;">3</span></a>
                   
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
		<div style="padding:10px;"></div>
		<div class="container " id="div11">
			<div class="row col-xs-10 col-xs-offset-1 ">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color:rgba(247,238,214,0.4);">
						<h4>当前位置&gt;参与问卷调查</h4>
					</div>
					<div class="panel-body">
					<c:forEach items="${list_wenJuan_message }" var="wj_l">
						<form action="oooo" class="form-horizontal" method="post">
						
						    <div class="form-group well hidden">
								<label class="control-label col-md-3">问卷id:</label>
                                <div class="col-md-6" >
                                	<input type="text"   value="${wj_l.qid }" class="form-control" name="qid"/>
                                </div>								
							</div>
						
						    <div class="form-group well ">
								<label class="control-label col-md-3">会议标题:</label>
								<p class=" col-offset-3 col-md-6">
								<span style="font-size:1.5em;color: rgba(255,255,255,1);"><strong>${wj_l.meet_title}</strong></span>
								</p>
								<div class="col-md-6 hidden" >
                                	<input type="text"  value="${wj_l.meet_title}" class="form-control" name="meet_title" />
                                </div>	
							</div>
							
							<div class="form-group well">
								<label class="control-label col-md-3">问卷标题:
								</label>
								<p class=" col-offset-3 col-md-6">
								<span style="font-size:1.5em;color: rgba(255,255,255,1);"><strong>${wj_l.wen_juan_theme}</strong></span>
								</p>
								<div class="col-md-6 hidden" >
                                	<input type="text"  value="${wj_l.wen_juan_theme}" class="form-control" name="wen_juan_theme" />
                                </div>	
							</div>
							<div class="form-group well" >
								<label class="control-label col-md-3">${wj_l.wen_ti1}</label>
								<div class="col-md-6">
									<input type="text" class="form-control" placeholder="请输入回答，默认不超过30个字" name="hui_da1"/>
								<!--动态增加-->
								</div>
							</div>
							<div class="form-group well" >
								<label class="control-label col-md-3">${wj_l.wen_ti2}</label>
								<div class="col-md-6">
									<input type="text" class="form-control" placeholder="请输入回答，默认不超过30个字" name="hui_da2"/>
								<!--动态增加-->
								</div>
							</div>
							<div class="form-group well" >
								<label class="control-label col-md-3">${wj_l.wen_ti3}</label>
								<div class="col-md-6">
									<input type="text" class="form-control" placeholder="请输入回答，默认不超过30个字" name="hui_da3" />
								<!--动态增加-->
								</div>
							</div>
							
							<div class="form-group well" id="wen_ti44">
								<label class="control-label col-md-3" id="wen_ti4">${wj_l.wen_ti4}</label>
								<div class="col-md-6">
									<input type="text" class="form-control" placeholder="请输入回答，默认不超过30个字" name="hui_da4"/>
								<!--动态增加-->
								</div>
							</div>
							
							<div class="form-group well" id="wen_ti55" >
								<label class="control-label col-md-3" id="wen_ti5" >${wj_l.wen_ti5}</label>
								<div class="col-md-6">
									<input type="text" class="form-control" placeholder="请输入回答，默认不超过30个字" name="hui_da5"  />
								<!--动态增加-->
								</div>
							</div>
							
							<div class=" col-md-offset-6 col-md-6">
								<button class="btn btn-success " id="toupiao1" >提交问卷</button>
								<button class="btn btn-warning" disable="none">取消问卷</button>
						    </div>
						</form>
					</c:forEach>
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
	<script type="text/javascript">
	$(function(){
	var  wenti1 =$("#wen_ti4").text();
	var  wenti =$("#wen_ti5").text();
	if(wenti1.length==0){
		$("#wen_ti44").addClass("hidden");
	}
	if(wenti.length==0){
		$("#wen_ti55").addClass("hidden");
	}
	})
	</script>
	</body>
</html>