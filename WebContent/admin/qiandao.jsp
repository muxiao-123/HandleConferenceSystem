<%@page import="conference.handle.bean.Organizer"%>
<%@page import="conference.handle.bean.Attendees"%>
<%@page import="java.text.*" %>
<%@page import="java.util.*" %>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>与会者主页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/jquery.qrcode.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js" ></script>
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
    <div class="container" id="div11">
			<div class="row">
				<div class="panel panel-info">
					<div class="panel-heading">
						<p>标题：${Qd_list.getMeet_title()}</p>
						<p>签到情况:<span>总报名数:${Qd_list.getAllBM()}</span><span>签到总数：${Qd_list.getAllQD()}</span><span>签到数:${Qd_list.getUserK() }</span><span>待签到数：${Qd_list.getAllNQD()}</span><span>补签数：${QD_list.getUserK1()}</span></p>
						<span>二维码生成时间</span><input type="text" id="ppp" name="time_tt" class="hidden" value=""></input>
						<%
						         Date date=new Date();
						         SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						         //获取当前二维码刷新时间
						         // Organizer org  =(Organizer)request.getSession().getAttribute("org");
						         //HttpSession s=request.getSession();
						         //Object info= s.getAttribute("org");
						         //String start=String.valueOf(aid);
						         //session.getAttribute("org");
						         //${ org.getOid()}
						        // int aid =org.getOid();
						       
						         String now=sdf.format(date);
						         //存到全局变量中
						         //时间映射成组织者的名字
						         request.getServletContext().setAttribute("start", now);
						%>
					</div>
					<div class="panel-body">
						<div class="col-md-4">
							<div class="well">
								<div id="qrcode" ></div>
							</div>
							<div class="well">
									<p>会议签到二维码</p>
							</div>
						</div>
						<div class="col-md-6">
							<div>
								<ul class="list-group">
								  <li class="list-group-item list-group-item-success" disabled="none">签到总人员信息</li>
								  <li class="list-group-item list-group-item-success" disabled="none">签到人员</li>
								  <c:forEach items="${ Qd_list.getAllUserK()}" var="qd_i">
								      <li class="list-group-item list-group-item-info">
								                    用户名：${qd_i.getA_userName()} 签到时间：${qd_i.getQd_time()}
								          <span class="label label-success pull-right">签到成功</span>
								      </li>
								  </c:forEach>
								  <li class="list-group-item list-group-item-success" disabled="none">补签人员</li>
								  <c:forEach items="${ Qd_list.getAllUserK1()}" var="qd_i1">
								      <li class="list-group-item list-group-item-danger">
								                    用户名：${qd_i1.getA_userName()} 签到时间：${qd_i1.getQd_time()}
								          <span class="label label-success pull-right">签到成功</span>
								      </li>
								  </c:forEach>
								</ul>
							</div>
				        </div>
				        <div class="col-md-2">
							<div>
								<ul class="list-group">
								  <li class="list-group-item list-group-item-success" disabled="none">签到统计</li>
								  <li class="list-group-item list-group-item-info">报名人数：${Qd_list.getAllBM()}</li>
								  <li class="list-group-item list-group-item-warning">已签到数：${Qd_list.getAllQD() }</li>
								  <li class="list-group-item list-group-item-danger">未签到数：${Qd_list.getAllNQD()}</li>
								  <li class="list-group-item list-group-item-success disabled="none">未签到人员名单</li>
								  <c:forEach items="${Qd_list.getAllUserN()}" var="qd_i2">
								      <li class="list-group-item list-group-item-info">
								                    用户名:${qd_i2} 
								          <span class="label label-info pull-right">未签到</span>
								      </li>
								  </c:forEach>
								</ul>
							</div>
						</div>
					</div>
					<div class="panel-footer ">
						针对与签到失败者，可手工添加签到信息
						<button class="btn btn-default" id="button33">补签</button>
					</div>
					
				</div>
				<!--
                	作者：582775919@qq.com
                	时间：2019-03-20
                	描述：补签表
                -->
                <div class="hidden" id="buqian1">
					<div class=" col-xs-offset-1 col-xs-10 col-md-4 col-md-offset-1" >
			 		<div style="background-color: rgba(96,96,96,0.1)">
			 			<form action="../ppppp" class="form-horizontal" method="post" >
			 				<div class="form-group">
			 				    <label class="control-label">会议标题</label>
			 				<div >
			 					<input type="text" required autofocus placeholder="请输入会议标题" class="form-control" name="meet_title" />
			 				</div>
			 				</div>
			 				
			 				<div class="form-group">
			 					<label class="control-label">您的姓名</label>
			 					<div class="">
			 						<input type="text" required class="form-control" placeholder="请输入补签人员姓名" />
			 					</div>
			 				</div>
			 				
			 				<div class="form-group">
			 					<input type="submit" class="btn btn-default" value="确定补签" class="form-control" />
			 				</div>
			 			</form>
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
                <!--<li class="sidebar-brand">
                    <a href="#">
                     用户中心
                    </a>
                </li>-->
                <li>
                    <a href="Myconference.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" aria-expanded="false" href="" data-toggle="dropdown">
                  	<span class="glyphicon glyphicon-list-alt"></span> 我的会议 <span class="caret"></span>
                   </a>
                  <ul class="dropdown-menu" role="menu" >
                    <li class="dropdown-header"></li>
                    <li><a href="Myconference.jsp">已发布会议</a></li>
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
                    <a href="#"><span class="glyphicon glyphicon-hand-right"></span> 发起签到</a>
                </li>
                 <li>
                    <a href="xiaoxi.jsp"><span class="glyphicon glyphicon-pencil"></span> 发送消息</a>
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

	
	<script>
		$(function(){
			//$("#qrcode").qrcode("http://www.baidu.com");
			$("#qrcode").qrcode({width: 300,height: 300,text: "http://localhost:8080/HandleConferenceSystem/qiandao.jsp"});
		})
	</script>
	<script>
			$(function(){
//				生成时间戳,判断是否二维码过期
			var t=new Date();
			var year=t.getFullYear();
			var month=t.getMonth();
			var day=t.getDate();
			var week=t.getDay();
			var hour=t.getHours();
			var minute=t.getMinutes();
			var second=t.getSeconds();
			var showTime=year+"-"+month+"-"+day+" "+hour+((minute<10)?":0":":")+minute+((second<10)?":0":":")+second;
			$("#ppp").append(showTime);
			})
	</script>
	<script>
		$(function(){
			$("#button33").click(function(){
				$("#buqian1").toggleClass();
			});
		})
	 </script>
	</body>
</html>