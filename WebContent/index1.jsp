<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登陆用户首页</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/zuoceguding.js" ></script>
		<style type="text/css">
			.list-group-item{
				background-color:rgba(0,191,255,0.4);
			}
			.panel-default>.panel-heading{
				background-color:rgba(0,191,255,0.4);
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
							<li class="active">
								<a href="index1.jsp">首页</a>
							</li>
							<li>
								<a href="#">会议中心</a>
							</li>
							<li>
								<a href="yuhuiban.jsp">用户中心</a>
							</li>
							<li>
								<a href="pppp?currentPage=1">退出登陆</a>
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
	    
	    <div style="padding:15px"></div>
		<div class="container ">
			<div class="row">
			   <div class="container" >
			   	<div class=" col-xs-12 col-md-8">
			   		<div class="container-fluid ">
			   		
					  <div class="col-xs-12 ">
			            	<div class="text-center">
			            		 <p style="font-size:2em;color: rgba(0,0,0,1);">会议信息&nbsp;CONFERENCE INFORMATION</p>	
			            	</div>
					  </div>
			
			<!--遍历输出 会议  -->
					 <c:forEach items="${page.list}" var="meets">
						<div class=" col-xs-12 col-md-12 ">
						    <div class="list-group">
								<div class="list-group-item" style="border: 0;">
								 <!--  <input type="text" value="${meets.meet_id}" class="hidden"/> -->
									<h5>
									  <a href="gggg?meet_id=${meets.meet_id}&youke=you">${meets.meet_title }</a>
                                     </h5>
										<p class="text-muted">
											<small>会议时间:${meets.startDate}至${meets.endDate}</small>
											<small>举办地点:${meets.address}</small>
											
										</p>
									<p class="text-muted">会议概况:</p>
									<p>${meets.meet_points}</p>
									
							    </div>
						    </div>
					    </div>
					   </c:forEach>
						<div class="col-xs-12 col-md-12 ">
							<div class="list-group">
								<div class="text-center">
									<ul class="pagination">
										<c:if test="${page.currentPage !=1 }">
											<li><a href="AllHuiYiServlet?currentPage=1">首页</a></li>
											<li><a href="AllHuiYiServlet?currentPage=${page.currentPage-1 }">上一页</a></li>
										</c:if>
									<c:forEach begin="1" end="${page.totalPage }" var="i">
										<c:if test="${page.currentPage==i} ">
										      ${i }
										</c:if>
										<c:if test="${page.currentPage!=i }">
										     <li><a href="AllHuiYiServlet?currentPage=${i }">${i}</a></li>
										</c:if>
									</c:forEach>
									<c:if test="${page.currentPage!=page.totalPage }">
										<li><a href="AllHuiYiServlet?currentPage=${page.currentPage+1 }">下一页</a></li>
										<li><a href="AllHuiYiServlet?currentpage=${page.totalPage }">尾页</a></li>
									</c:if>
								</ul>
								</div>
							</div>	
					    </div>
					    
		            </div>
			   	</div>
			   	
			   	<div class="col-xs-12 col-md-4 ">
			   		<div class="panel panel-default">
			   			<div class="panel-heading">
			   				投票栏
			   				<span class="pull-right">
			   					<a href="#">
			   						更多
			   						<span class="glyphicon glyphicon glyphicon-share-alt"></span>
			   					</a >
			   				</span>
			   			</div>
			   			<div class="panel-body">
			   			<p>投票内容<span class="glyphicon glyphicon-hand-down"></span><span class="pull-right">来自会议<span class="glyphicon glyphicon-hand-down"></span></span> </p>
			   			<c:forEach items="${v_list }" var="v_l">
			   			    <p><a href="tttt?meet_title=${v_l.meet_title }">${v_l.vote_content}<span class="pull-right">${v_l.meet_title }</span></a></p>
			   			 </c:forEach>
			   			</div>
			   		</div>
			   	</div>
			   		<div class="col-xs-12 col-md-4 ">
			   		<div class="panel panel-default">
			   			<div class="panel-heading">
			   				问卷栏
			   				<span class="pull-right">
			   					<a href="#">
			   						更多
			   						<span class="glyphicon glyphicon glyphicon-share-alt"></span>
			   					</a >
			   				</span>
			   			</div>
			   			<div class="panel-body">
			   			<p>问卷主题<span class="glyphicon glyphicon-hand-down"></span><span class="pull-right">来自会议<span class="glyphicon glyphicon-hand-down"></span></span> </p>
			   			<c:forEach items="${wj_list }" var="wj_l">
			   			    <p><a href="yyyy?meet_title=${wj_l.meet_title }">${wj_l.meet_title }<span class="pull-right">${wj_l.meet_title }</span></a></p>
			   			</c:forEach>
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