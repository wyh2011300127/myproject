<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath }/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath }/styles/global_color.css" /> 
    </head>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/layui/layui.all.js"></script>
    <script type="text/javascript">
    	layui.use('layer', function(){
    		var layer = layui.layer;
    	});
    	
    	function btn_add(){
    		var msg = "是否确认操作？";
    		//eg1
    		//layer.alert('酷毙了', {icon: 1});
    		//eg2
    		//layer.msg('不开心。。', {icon: 5});
    		//eg3
    		//layer.load(1); //风格1的加载
   			var isIndex = layer.open({
   				title:'提示',
   				content:msg,
   				icon:'3',
   				btn:['确定','取消'],
   				yes:function(){
   					layer.close(isIndex);
   					alert(111);
   				},
   				btn2:function(){}
   			});
    		return false;
    		layer.open({
    			title:['欢迎来到英雄联盟','text-align:center;'],
    			type:'1',
    			area:['300px','200px'],
    			content:'hahahahah'
    		});
    	}
    	function btn_add2(){
    		layer.tab({
   			  area: ['600px', '300px'],
   			  tab: [{
   			    title: 'TAB1', 
   			    content: '内容1'
   			  }, {
   			    title: 'TAB2', 
   			    content: '内容2'
   			  }, {
   			    title: 'TAB3', 
   			    content: '内容3'
   			  }]
   			});
    	}
    	function btn_add3(){
    		layer.prompt({
   			  formType: 2,
   			  value: '初始值',
   			  title: '请输入值',
   			  area: ['800px', '350px'] //自定义文本域宽高
   			}, function(value, index, elem){
   			  alert(value); //得到value
   			  layer.close(index);
   			});
    	}
    	function btn_add4(){
    		//var index = layer.load(1);
    		var index = layer.load(2, {time:10*1000});//加载10秒钟
    		//layer.close(index);
    	}
    	//页面一打开就执行弹层
    	/* layer.ready(function(){
    	  layer.msg('很高兴一开场就见到你');
    	});  */ 
    </script>
    <body>
    	<!--Logo区域开始-->
        <div id="header">
            <img src="${pageContext.request.contextPath }/images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <jsp:include page="../common/nav.jsp"/>
        </div>
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="POST">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="btn_add4();" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>                            
                            <th>角色 ID</th>
                            <th>角色名称</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>                      
                        <tr>
                            <td>1</td>
                            <td>贾强</td>
                            <td>角色管理、管理员管理、资费管理、账务账号、业务账号、账单、报表</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='role_modi.html';"/>
                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole();" />
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>贾强</td>
                            <td>超级管理员、账单管理员</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>贾强</td>
                            <td>超级管理员、账单管理员</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>贾强</td>
                            <td>超级管理员、账单管理员</td>
                            <td>
                                <input type="button" value="修改" class="btn_modify" />
                                <input type="button" value="删除" class="btn_delete" />
                            </td>
                        </tr>
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>