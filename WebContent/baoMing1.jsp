<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>报名参会</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="css/Nav.css" />
		<script type="text/javascript" src="admin/js/jquery-3.3.1.min.js" ></script>
		<script type="text/javascript" src="admin/js/bootstrap.min.js" ></script>
	</head>
	<body id="beijing">
		<div style="padding: 60px;"></div>
		<div class="container">
			<div class="row">
				<div class="col-xs-10 col-xs-offset-1 col-md-offset-2" >
					<div class="well col-md-9 ">
					<p style="text-align: center;font-size: 2em;color: rgba(255,255,255,1);">报&nbsp;名&nbsp;参&nbsp;会</p>
					<p style="text-align: center;font-size: 2em;color: rgba(255,255,255,1);">CONFERENCE REGISTRATION</p>
					
					<div class="container col-md-12 ">
						<div class="row">
							<form action="hhhh" method="post" class="form-horizontal col-md-10 col-md-offset-1" id="form22" >
								<div class="text-center">
									<div class="form-group  ">
									    <input type="text" value="<%= request.getParameter("meet_id") %>" name="meet_id" class="form-control" />
								    </div>
								</div>
								<div class="text-center">
									<div class="form-group  ">
									    <input type="text" name="meet_title" class="form-control"placeholder="请输入您所要参加的会议标题" />
								    </div>
								</div>
								<div class="text-center">
									<div class="form-group ">
									    <input type="text" placeholder="请输入您的用户名" name="a_userName" class="form-control col-md-5" />
								    </div>
								</div>
								<div class="text-center">
									<div class="form-group ">
										<input name="a_email" class="form-control" placeholder="请输入注册时的邮箱/或者现有邮箱"/>
								    </div>
								</div>
								<div class="text-center">
									<p style="color: rgb(255,255,255);font-size: 1.5em;">${msg }</p>
									<p style="color: rgb(255,255,255);font-size: 1.5em;">${msg1 }</p>
								</div>
								<div class="form-group ">
									<div class="text-center">
									    <button class=" btn btn-primary "  >
									    确&nbsp;定&nbsp;报&nbsp;名
									    </button>
								    </div>
								</div>
			                </form>
						</div>
					</div>
					    
				    </div>
				</div>
			</div>
		</div>
	
		
	</body>
</html>