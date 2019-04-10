<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <h3>这是检查是否发布了该签到</h3>
    <form action="qiandao.jsp" method="get">
         <input type="text"  required  placeholder="请输入所要签到的会议标题" name="meet_title"/>
         <input type="submit" value="提交"/>
    </form>

</body>
</html>