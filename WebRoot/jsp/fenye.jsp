<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="../css/fenye.css" type="text/css"></link>
	
<script type="text/javascript" src="../js/common/jquery.min.js"></script>
<script type="text/javascript" src="../js/common/jquery.page.js"></script>
<script type="text/javascript" src="../js/fund.js"></script>
  
</head>
<body>
<!-- 代码部分begin -->
    <div class="tcdPageCode">
    </div>
</body>

<script>
    $(".tcdPageCode").createPage({
        pageCount:6,
        current:1,
        backFn:function(p){
            console.log(p);
        }
    });
</script>
<!-- 代码部分end -->
</html>