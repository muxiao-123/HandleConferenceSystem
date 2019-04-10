<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>发布会议</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.min.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js" ></script>
		<script type="text/javascript" src="js/moment-with-locales.min.js" ></script>
		<script type="text/javascript" src="https://cdn.bootcss.com/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
		<style>
			
			.jumbotron{
				background-color:rgba(0,191,255,0.4);
			}
			.well{
				background-color: rgba(247,238,214,0.3);
				height: 50px;
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
		
		<div style="padding: 10px;"></div>
		<div class="container" id="div11">
			<div class="row">
				<div class="jumbotron col-xs-10 col-xs-offset-1">
					<div class="well">当前位置：新建会议</div>
					<form action="dddd" method="post" class="form-horizontal" id="form2">
						<div class="form-group">
							<label class="control-label   col-md-3">会议标题:</label>
							<div class=" col-md-6">
								<input type="text" autofocus  required placeholder="请输入会议标题" class="form-control" name="meet_title" />
							</div>
						</div>
						<div class="form-group">
					    	<label class="control-label col-md-3">会议概况:</label>
					    	<div class="col-md-9">
					    	   <textarea class="form-control" required style=" width:100%;height: 70px;" name="meet_points">
					    	   </textarea>
					    	</div>
					    </div>
						
						<div class="form-group">
							<label class="control-label   col-md-3">参会人数:</label>
							<div class=" col-md-6">
								<input type="number" required placeholder="请输入参会人数:例如：30" class="form-control" name="number" />
							</div>
						</div>
						
						<div class="form-group"> 
							<label class="control-label col-md-3">会议开始日期:</label>
							<!--指定 date标记-->
							<div class='input-group date' id='datetimepicker1'>
								<div class='col-md-9 '>
									<input type='text' class="form-control" name="startDate" /> 
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar">
										</span> 
									</span>
								</div>
							</div>
					    </div>
					    <div class="form-group">
							<label class="control-label col-md-3">会议结束日期:</label>
							<!--指定 date标记-->
							<div class='input-group date' id='datetimepicker2'>
								<div class='col-md-9'>
									<input type='text' class="form-control" name="endDate" /> 
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-calendar">
										</span> 
									</span>
								</div>
						    </div>
					    </div>
					    
					    <div class="form-group">
					    	<label class="control-label col-md-3">会议地址:</label>
					    	<div class="col-md-6">
					    		<input type="text" required class="form-control " placeholder="请输入会议地址" name="address" />
					    	</div>
					    </div>
					    
					    <div class="form-group">
					    	<label class="control-label col-md-3">会议主持人:</label>
					    	<div class="col-md-6">
					    		<input type="text" required class="form-control" placeholder="请输入会议主持人：例如张三" name="toastMaster" />
					    	</div>
					    </div>
					    
					    <div class="form-group">
					    	<label class="control-label col-md-3">会议主办方:</label>
					    	<div class="col-md-6">
					    		<input type="text" required class="form-control" placeholder="请输入会议主办方：例如，韶关创业大队" name="sponsor" />
					    	</div>
					    </div>
					    
					    <div class="form-group">
					    	<label class="control-label col-md-3">会议详情:</label>
					    	<div class="col-md-9">
					    	   <textarea class="form-control" required style=" width:100%;height: 200px;"name="meetInfo">
					    	   </textarea>
					    	</div>
					    </div>
					    
					    <div class="col-md-offset-3">
					    	<input type="submit" class="btn btn-primary" value="确定发布" />
					    </div>
					    
					</form>
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
		
		<script type="text/javascript">
	       $(function(){
	       	var picker1=$('#datetimepicker1').datetimepicker({
	               			format:'YYYY-MM-DD HH:mm:ss',//设置格式
	               			locale:moment.locale('zh-cn'),
	               			defaultDate:'2019-01-02 15:00:00'//默认开始时间
	               		});
	        var picker2=$('#datetimepicker2').datetimepicker({
		                	format:'YYYY-MM-DD HH:mm:ss',
		                	locale:moment.locale('zh-cn'),
		                	defaultDate:'2019-01-02 17:00:00'
		                });
		         picker1.on('dp.change',function(e){
		         	picker2.data('DataTimePicker').minDate(e.date);
		         });
		         picker2.on("dp.change",function(){
		         	picker1.Data('DateTimePicker').maxDate(e.date);
		         })
	       	});
		</script>
	</body>
</html>