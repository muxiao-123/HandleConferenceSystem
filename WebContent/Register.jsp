<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>注册界面</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<style>
		  .well{
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
						<a href="bangzhuzhongxin.html" class="btn btn-primary btn-sm navbar-btn navbar-right hidden-xs">联系我们</a>
						<div class="profile navbar-right">
							<ul class="nav navbar-nav">
								<li ><a href="Login.html">登陆</a></li>
								<li class="active"><a href="Register.jsp">注册</a></li>
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
                                            <!--   空行，以防遮住头部                                         -->
		<!--
        	头部
        -->
        <div class="container" id="div11">
        	<div class="row">
        		<div class="col-xs-10 col-xs-offset-1 col-md-6 col-md-offset-3">
	            <div class="well">
	        		<div class="">
        			<h4><span class="glyphicon glyphicon-plus">&nbsp;用户注册</span></h4>
        		    </div>
        		<div class="">
        			<!--
                    	注册表单项
                    -->
                                 <!--只能注册与会人员信息，组织人员注册需管理员手动添加-->
                                 
        			<form action="bbb" method="post" class="form-horizontal" id="form-login">
		        		<div class="form-group">
		        			<div class="col-xs-offset-2 col-xs-8 col-md-6 col-md-offset-3">
		        			    <div class="input-group">
			        				<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
				        			<input type="text"  autofocus  required placeholder="用户名" class="form-control" name="userName" />
			        			</div>
		                    </div>      		
		        		</div>
		        		<div class="form-group">
		        			<div class="col-xs-offset-2  col-xs-8 col-md-6 col-md-offset-3">
		        			    <div class="input-group">
		        					<span class="input-group-addon"><span class="glyphicon glyphicon-eye-open"></span></span>
		        			         <input type="password" required id="passwd" placeholder="密码" class="form-control" name="password" />
		        			    </div>
		                    </div>      		
		        		</div>
		        		<div class="form-group">
		        			<div class="col-xs-offset-2 col-xs-8 col-md-6 col-md-offset-3">
		        			    <div class="input-group">
		        					<span class="input-group-addon"><span class="glyphicon glyphicon-eye-open"></span></span>
		        			        <input type="password" required id="passwd1" placeholder="确定密码" class="form-control" onkeyup="validate()" />
		        			        <span class="input-group-addon" id="tishi"></span>
		        			    </div>
		                    </div>      		
		        		</div>
		        		<div class="form-group">
		        			<div class="col-xs-offset-2 col-xs-8 col-md-6 col-md-offset-3">
		        			    <div class="input-group">
		        					<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
		        			         <input type="email"  required placeholder="邮箱" class="form-control" name="email" />
		        			    </div>
		                    </div>      		
		        		</div>
		        		<div class="form-group">
		        			<div class="col-xs-offset-2 col-xs-8 col-md-6 col-md-offset-3">
		        			    <div class="input-group">
		        					<span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
			        			    <input type="tel" id="mobilephone"  placeholder="电话号码" class="form-control" name="mobilePhone" />
			        			</div>
		                    </div>      		
		        		</div>
		        		<div class="form-group">
		        			<div class="col-xs-offset-2 col-xs-6 col-md-6 col-md-offset-3 ">
		        			<input type="submit" class="btn btn-primary  col-xs-9 col-md-12 form-control" value="确定注册" />
		                    </div>      		
		        		</div>
		        		<div class="form-group">
		        			<div class="col-xs-offset-2 col-xs-10 col-md-6 col-md-offset-3">
		        			<input type="checkbox" required id="check"  />
		        			<span>您已认真阅读<a href="#">用户手册</a></span>
		                    </div>      		
		        		</div>
				    </form>
	        	</div>
		        </div>
	        	</div>
        	</div>
        </div>
        <!--
        	身体
        -->
      
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
        <!--
        	尾部
        -->
        <!-- 密码判断 -->
        <script>
			function validate() {
			var pw1 = document.getElementById("passwd").value;
			var pw2 = document.getElementById("passwd1").value;
			if(pw1 == pw2) {
			document.getElementById("tishi").innerHTML="<span class='glyphicon glyphicon-ok' style='color: #449D44;'></span>";
			}
			else {
			document.getElementById("tishi").innerHTML="<span class='glyphicon glyphicon-remove' style='color:#C0392B'></span>";
			}
			}
		</script>
	</body>
</html>