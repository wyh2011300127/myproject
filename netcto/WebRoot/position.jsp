<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'position.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.div{height:150px;width:150px;border:3px solid red;margin-top:10px;}
		.div1{height:50px;width:50px;border:2px solid blue;margin-top:5px;float:left;margin-right:5px;}
	</style>
	
  </head>
  
  <body>
    This is my JSP page. <br>
    <div style="border:2px solid green;">
    	<div class="div">我是第一个DIV</div>
    	<!-- 相对定位 -->
     	<div class="div" style="position:relative;left:50px;">我是一个DIV</div>
      	<div class="div">我是第二个DIV</div>
      	<div class="div" style="position:relative;left:50px;top:50px;">我是第三个DIV</div>
        <div class="div">我是第四个DIV</div>
        
        <!-- 绝对定位实例 -->
        <div class="div" style="position:absolute;left:100px;top:100px;">我是绝对定位DIV</div>
        
        <div class="div" style="height:400px;width:200px;">
        	<div class="div1">我是div10</div>
        	<div class="div1">我是div11</div>
        	<div class="div1">我是div12</div>
        	<div class="div1">我是div13</div>
        	<div class="div1">我是div14</div>
        	<div class="div1">我是div15</div>
        </div>
        <!-- 浮动定位 -->
        <div class="div" style="height:400px;width:400px;">
       		<div style="float:right;width:50px;height:50px;border:2px dotted black;margin:0px 0px 10px 20px;"></div>
        	<p>
        		This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
        	</p>
        </div>
        <div class="div" style="height:400px;width:400px;">
        	<p>
        		<span style="float:left;width:0.7em;font-size:400%;font-family:algerian,courier;line-height:80%;">T</span>his is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
		        This is some text. This is some text. This is some text.
        	</p>
        </div>
        
        <div class="div" style="height:400px;width:600px;">
	        <ul>
				<li style="float:left;display:inline;margin:0px 3px 0px 3px;"><a href="#">Link one</a></li>
				<li style="float:left;display:inline;margin:0px 3px 0px 3px;"><a href="#">Link two</a></li>
				<li style="float:left;display:inline;margin:0px 3px 0px 3px;"><a href="#">Link three</a></li>
				<li style="float:left;display:inline;margin:0px 3px 0px 3px;"><a href="#">Link four</a></li>
			</ul>
        </div>
        
    </div>
  </body>
</html>
