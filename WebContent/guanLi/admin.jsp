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
							<li>
								<a href="allHuiYi.jsp">会议</a>
							</li>
							<li  class="active">
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
		<div class="container" id="div11">
			<div class="row col-md-9 col-md-offset-2 ">
			<div style="padding:25px"></div>
			    <div>
					<nav role="navigation" class="col-md-2">
						<ul class="nav nav-tabs nav-stacked">
				            <li role="presentation" class="success lili" >
				            	<a href="#xxx" data-toggle = "tab">与会人员</a>
				            </li>
				            <li role="presentation" class="active lili"><a href="#aaa" data-toggle = "tab">组织人员</a></li>
		                 </ul>
					</nav>
					<div class="tab-content col-md-9" >
						<div class="tab-pane fade in active" id="xxx">
				             <div class="table-responsive">
								<table class="table table-striped table-bordered ">
									<thead>
										<tr class="danger"><td colspan="6">全体与会者</td></tr>
										<tr class="info">
										    <td>与会id</td>
											<td>用户名</td>
											<td>邮箱</td>
											<td>电话</td>
											<td></td>
										</tr>
									</thead>
									<tbody >
									<c:forEach items="${list_a}" var="list">
										<tr>
										    <td>${list.aid}</td>
											<td>${ list.userName}</td>
											<td>${list.email}</td>
											<td>${ list.mobilePhone}</td>
											<td><a href="nihao?aid=${list.aid}" class="btn btn-default">删除</a>
												<c:if test="${aid==list.aid }">
												   <span>${msg1}</span>
												</c:if>
											</td>
											
										</tr>
									</c:forEach>
										<tr>
											<td colspan="3" ></td>
										    <td><button disabled="none" class="btn btn-default">添加</button></td>
										</tr>
									</tbody>
								</table>
							</div>
					  </div>
					    <div class="tab-pane fade" id="aaa">
					      <div>
					    	<div class="table-responsive">
								<table class="table table-striped table-bordered ">
								
								<thead>
									<tr class="success"><td colspan="6">全体组织者</td></tr>
									<tr class="info">
									    <td>与会id</td>
										<td>用户名</td>
										<td>邮箱</td>
										<td>电话</td>
										<td></td>
									</tr>
								</thead>
								<tbody >
								<c:forEach items="${list_o }" var="list_o">
									<tr>
									    <td>${list_o.oid}</td>
										<td>${list_o.o_userName}</td>
										<td>${list_o.o_email}</td>
										<td>${list_o.o_mobilePhone}</td>
										<td><a href="nihao?oid=${list_o.oid}" class="btn btn-default">删除</a>
											<c:if test="${oid==list_o.oid }">
											     <span>${msg}</span>
											</c:if>
										</td>
									</tr>
								</c:forEach>
									<tr>
										<td colspan="3" >如果需要添加组织者，请点击右边按钮${msg2}</td>
									    <td><button class="btn btn-default" id="ok">添加</button></td>
									</tr>
								</tbody>
							    </table>
						    </div>
						    <div id="div13" class="hidden">
								<div class="container col-md-3 col-md-offset-8 well">
								<div class="form-horizontal" >
									<form action="../bbb" method="post">
										<div class="form-group">
											<input type="text" class="form-control" required placeholder="组织者名" id="o_userName" name="o_userName" />
										</div>
										<div class="form-group">
											<input type="text" class="form-control" required placeholder="初始密码" id="o_password" name="o_password" />
										</div>
										<div class="form-group">
											<input type="email" class="form-control" required placeholder="邮箱" id="o_email" name="o_email"/>
										</div>
										<div class="form-group">
											<input type="text" class="form-control" required placeholder="电话" id="o_mobilePhone" name="o_mobilePhone" />
										</div>
										<div>
											<input type="submit" class="btn form-control btn-default" value="提交" />
										</div>
										<div class="form-group vi" id="text">
										     <p>${msg4 }</p>
										</div>
									</form>
								</div>
							    </div>
							</div>
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
		<script>
			$(function(){
				$("#ok").click(function(){
					$("#div13").toggleClass();
				})
			})
		</script>
	</body>
</html>