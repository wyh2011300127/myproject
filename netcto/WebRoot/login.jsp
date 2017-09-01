<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>达内－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" /> 
    <script type="text/javascript" src="js/jquery/jquery-1.10.2.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("#admin").focus();
    		//登陆login()
    		$("#login_btn").click(function(){
    			login();
    		});
    	});
    	function login(){
    		//检验账号
    		var $admin = $("#admin").val();
    		if($admin == "" ){
    			$("#admin_msg").html("账号为空");
    			return false;
    		}
    		if($admin.length > 30){
    			$("#admin_msg").html("账号长度大于30");
    			return false;
    		}
    		$("#admin_msg").html("账号格式正确");
    		//检验密码
			var $pwd = $("#password").val();
    		if($pwd == ""){
    			$("#password_msg").html("密码为空");
    			return false;
    		}
    		if($pwd.length > 20 ){
    			$("#password_msg").html("密码长度大于20");
    			return false;
    		}
    		$("#password_msg").html("密码格式正确");
    		//检验验证码
			var $yzm = $("#yzm").val();
			if($yzm == "" ){
				$("#yzm_msg").html("验证码为空");
				return false;
			}
			if($yzm.length != 4){
				$("#yzm_msg").html("验证码长度不正确");
				return false;
			}
			$("#yzm_msg").html("");
			
			$("#img_login").attr("src","images/dongtai.gif");
			
    		$.ajax({
    			url:"${pageContext.request.contextPath }/login.do?t=" + new Date().getTime(),
    			type:"POST",
    			dataType:"JSON",
    			data:{"admin":$admin,"password":$pwd,"yzm":$yzm},
    			success:function(data){
    				var msg = data.msg;
    				if( data.loginResult == 0 ){
    					$("#img_login").hide();
    					window.location.href="${pageContext.request.contextPath }/index.do?t="+  new Date().getTime();
    				}else{
    					$("#img_login").hide();
    					$("#login_msg").html(msg);
    				}
    			},
    			error:function(x,y,z){
    				console.log(x);
    				console.log(y);
    				console.log(z);
    			}
    		});
    	}
    	
    	//校验验证码
    	function validateYzm(){
    		var $yzm = $("#yzm").val();
    		if( $yzm.length == 4 ){
    			$.ajax({
    				url : "${pageContext.request.contextPath }/validateYzm.do?t="+ new Date().getTime(),
    				type : "GET",
    				data : { "yzm":$yzm },
    				dataType : "json",
    				success : function(data){
    					var msg = data.msg;
    					if( data.loginResult == 0 ){
    						$("#yzm_msg").html(msg);
    						if( $("#admin").val() != "" &&
    								$("#yzm").val() != "" && $("#password").val() != "" ){
    							$("#login_btn").click();
    						}
    					}else{
    						$("#yzm_msg").html(msg);
    						$("#img_yzm").click();
    					}
    				},
    				error : function(x,y,z){
    					console.log(x);
    					console.log(y);
    					console.log(z);
    				},
    				complete : function(XHR,TS){
    					XHR = null;
    				}
    			});
    		}
    		
    	}
    </script>
    </head>
    <body class="index">
        <div class="login_box">
	        <form action="" method="post" id="form_data">
	        	<table>
	                <tr>
	                    <td class="login_info">账号：</td>
	                    <td colspan="2"><input name="admin" id="admin" type="text" class="width150" /></td>
	                    <td class="login_error_info"><span class="required" id="admin_msg" >30长度的字母、数字和下划线</span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">密码：</td>
	                    <td colspan="2"><input name="password" id="password" type="password" class="width150" /></td>
	                    <td><span class="required" id="password_msg" >20长度的字母、数字和下划线</span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">验证码：</td>
	                    <td class="width70"><input name="yzm" id="yzm" type="text" class="width70" maxlength="4" onkeyup="validateYzm();"/></td>
	                    <td><img id="img_yzm" src="${pageContext.request.contextPath }/identify.do" alt="验证码" title="点击更换" onclick="var s = Math.random();src='${pageContext.request.contextPath }/identify.do?1='+s;" /></td>  
	                    <td><span class="required" id="yzm_msg" ></span></td>              
	                </tr>            
	                <tr>
	                    <td></td>
	                    <td class="login_button" colspan="2">
	                        <a href="###" id="login_btn"><img src="images/login_btn.png" id="img_login" /></a>
	                    </td>    
	                    <td><span class="required" id="login_msg"></span></td>                
	                </tr>
	            </table>
	        </form>
        </div>
    </body>

</html>