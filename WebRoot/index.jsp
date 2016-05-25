<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keywrd2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form action="./servlet/CxjOne" method="post">
	用户名 <input type="text" name = "username" /> <br><br>&nbsp;&nbsp;
	密码&nbsp; <input type="text" name = "password"> <br>
	<input type = "submit" value = "提交">
	</form>
	
	
		<p>
		<img border="0" src="./images/pulpit.jpg" alt="Pulpit rock" width="304" height="228">
			<img border="0" src="./images/tu.png" alt="Pulpit rock" width="304" height="228">
		</p>
		<br>
		<a href="./index.jsp">重新登录xjjhj</a>
  </body>
</html>
