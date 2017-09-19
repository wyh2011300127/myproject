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
            <form action="" method="">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='role_add.html';" />
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