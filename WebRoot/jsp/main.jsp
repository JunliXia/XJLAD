<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/main.css" type="text/css"></link>
	 <link href="css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
     <script type="text/javascript" src="js/common/jq.js"></script>
     <script src="js/common/jquery.autocomplete.min.js" type="text/javascript"></script>
      
     <script type="text/javascript" src="js/common/file.js"></script>
  	 <script type="text/javascript" src="js/main.js"></script>
  	 <script type="text/javascript" src="js/common/date.js"></script>
  	 <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=xTGYDhxlbHjfvpB4CsrtxvsA"></script>
  </head>
  <body>
 
 <%
 	String UserAccount=request.getParameter("UserAccount");
    String UserId=request.getParameter("UserId");
 %>
  
  <script type="text/javascript">
  var UserAccount=<%=UserAccount%>
  var UserId=<%=UserId%>
  
  

 </script>
  
    <div class="front"><img src="./pic/tuichu.jpg" onclick="loginout()"  style="height:35px;width: 35px;position: relative;right: 30px;top: 10px;"/></div>
  	<div class="all">
  		<div class="left">
  			<div class="left_head">系统导航</div>
  			<div class="left_list">
  					<div class="one" id="userbit" onclick="changecolors(this),tofund()">基金管理</div>
  			</div>
  		</div>
  		<div class="right-title"></div>
  		<div class="right">
  			<div class="fund"></div>
  		</div>
  	</div>
  	<div class="shadow" style="display: none;">
  		<div class="showpage">
  			<div class="pagehead"><font></font><div class="closepage" onclick="closepage()"></div></div>
  			<div class="pagemain" style="padding: 5px;">
  				
  			</div>
  		</div>
  	</div>
  </body>
</html>
