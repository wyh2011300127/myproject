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
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
  <script type="text/javascript">
  	$(function(){
  		//json对象
	  	var person = {"name":"张三", "age":"14", "gender":"男"};
	  	console.log(person);
	  	console.log(person.gender);
  		console.log(typeof(person));
  		//json对象转成json字符串
  		var personToString = JSON.stringify(person);
  		console.log(personToString);
  		console.log(typeof(personToString));
  		
  		//json字符串串
  		var b = '{"A":"1", "B":"2", "C":"1"}';
  		console.log(b);
  		console.log(typeof(b));
  		console.log(b.length);
  		//json字符串转成json对象
  		var bToObject = JSON.parse(b);
  		console.log(bToObject);
  		console.log(typeof(bToObject));
  		console.log(bToObject.B);
  		
  		var arr = [];
  		var obj1 = {"name":"李四","age":"15","gender":"女"};
  		var obj2 = {"score":"90","hobby":"踢毽子","music":"带你去旅行"};
  		arr.push(obj1);
  		arr.push(obj2);
  		console.log(arr.length + "," + arr);
  		var arrToJsonString = JSON.stringify(arr);
  		console.log(arrToJsonString);
  		
  	});
	    
  	
  </script>
  <body>
    This is my JSP page. <br>
    <a href="${pageContext.request.contextPath}/servlet/HttpDemo">按钮</a>
    <input type="button" id="btn" value="按钮2">
  </body>
</html>
