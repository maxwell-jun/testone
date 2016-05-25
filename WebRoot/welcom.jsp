<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>登陆成功</title>
	
	</head>
	
	<body>
		欢迎你！登陆成功！<br>
		
	
		<%
		Date today = new Date();
		int d = today.getDay();
		int h = today.getHours();
		String s = "";
		if(h>0 && h < 12)
		s = "上午好";
		else if(h>=12)
		s = "下午好";
		String day[] = {"日","一","二","三","四","五","六"};
		out.println(s+ "，今天是星期" + day[d]);
		%>
		
		<!--  add some code 2016-5-5 -->
		<br>
		<h1>you are name is :<%=request.getAttribute("name_s")%></h1>
		<h2>you are password is :<%=request.getAttribute("password_s")%></h2>
		
		
		<p>
		<img border="0" src="../images/pulpit.jpg" alt="Pulpit rock" width="304" height="228">
			<img border="0" src="/testone/images/tu.png" alt="Pulpit rock" width="304" height="228">
		</p>
		<br>
		<a href="/testone/index.jsp">重新登录</a>
		
		
	</body>


</html>
