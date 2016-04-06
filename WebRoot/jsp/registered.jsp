<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  	 <link rel="stylesheet" href="css/login.css" type="text/css"></link>
     <script type="text/javascript" src="js/common/jq.js"></script>
  	 <script type="text/javascript" src="js/login.js"></script>
  </head>
  
  <body>
   	<div class="allregistered">
   	
   		<div style="height:100px"></div>
   		<div class="title">USER  REGISTERED</div>
   		<div class="register">
   			<div class="name"><font style="color:black">姓名：</font><input type="text"> </div>
   			<div class="account"><font style="color:black">帐号：</font><input type="text"> </div>
   			<div class="pass"><font style="color:black">密码：</font><input type="password"> </div>
   			<button onclick="registeredok()">确认</button>
   		</div>
   		
   	</div>
  </body>
</html>
