<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/wangEditor.min.css">
	<script type="text/javascript" src="js/lib/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/wangEditor.min.js"></script>
  </head>
  
  <body>

    <div style="width:90%">
	    <!--用当前元素来控制高度-->
	    <div id="div1" style="height:400px;max-height:500px;">
	        <p>请输入内容...</p>
	    </div>
	</div>

	<!--这里引用jquery和wangEditor.js-->
	<script type="text/javascript">
		wangEditor.config.mapAk = 'XeoBATnzf1ZYkajz5ifF0WO9aDpaG7xo';
	    var editor = new wangEditor('div1');
	    editor.config.mapAk = 'XeoBATnzf1ZYkajz5ifF0WO9aDpaG7xo';
	    editor.config.uploadImgUrl = '/blog/uploadimg';
	    editor.create();
	    editor.config.uploadImgFileName = 'uploadImg';
	    
	</script>
  </body>
</html>
