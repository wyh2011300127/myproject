<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>js判断字符是否是汉字</title>
<style type="text/css">
.content {
	width: 350px;
	overflow: hidden;
	border: 1px solid #ddd;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		alert("开始测试");
	});
	var test = document.getElementById("test");
	$(test).unbind().bind("onblur", function(){
		
	});
	
</script>
</head>
<body>
	<div class="content">
		<div>
			<input type="text" id="test"/>
		</div>
	</div>
</body>
</html>

