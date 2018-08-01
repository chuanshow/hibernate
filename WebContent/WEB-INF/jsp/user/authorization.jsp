<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>企业员工信息管理系统 ——用户授权</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
	<meta http-equiv="description" content="This is my page" />
	<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${pageContext.request.contextPath}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
	
</head>
<body>
	<!-- 导航 -->
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：权限管理 &gt; 用户授权</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
		<form name="flowsForm" method="post" id="flowsForm" action="${pageContext.request.contextPath}/user/selectUser.action">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="font3">
					    	用户名：<input type="text" name="userName">
					    	 <input type="submit" value="搜索"/>
					    	  <input type="button" value="保存" onClick="doAuthorization()"/>
					    </td>
					  </tr>
					</table>
				</form>
	<table id="flows" width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		<tr>
			 <td><input type="checkBox" id="checkAll" ></td> 
			 <td class="font3">用户登录名</td>
			  <td class="font3">用户名</td>
			   <td class="font3">当前用户身份</td>
			   <td class="font3">授权</td>
		</tr>
		<form id="authorization" name="authorization" method="post">
		<c:forEach items="${requestScope.users}" var="user" varStatus="stat">
			<tr>
		<td><input type="checkBox" id="uId" value="${user.id}" name="uId"></td> 
			<td class="font3">${user.loginName}</td>
			<td class="font3">${user.userName}</td>
			<td class="font3"><c:choose>
							<c:when test="${user.flag == 1}">
							          管理员
							</c:when>
							<c:when test="${user.flag == 0}">
							          普通用户
							</c:when>
						</c:choose></td>
					  <td>
					  	<select name="authorization" style="width:143px;">
					    			<option value="0,${user.id}">--请选择--</option>
					    			<option value="1,${user.id}">管理员</option>
					    			<option value="0,${user.id}">普通用户</option>
					    		</select>
					  </td>
					   </tr>
		</c:forEach>
		</form>
		</table>
		<script type="text/javascript">
		$(function(){
			 $("#checkAll").change(function(){//判断全选框的改变
			 	var flage =$(this).is(":checked");//全选选中为true，否则为false
			 	$("input[type=checkbox]").each(function(){
			 $(this).prop("checked",flage);
			 	})
			 })
			})
			function doAuthorization(){
			var obj = document.getElementsByName("uId");
			var check_val = [];	
			for(k in obj){
	    		if(obj[k].checked)
	        	check_val.push(obj[k].value);
			}
			if(check_val.length<1){
				alert("保存失败，未选择有效数据");
				return;
			}
			var url="${pageContext.request.contextPath}/flows/doAuthorization.action?uIds="+check_val;
			 document.authorization.action=url;
			 document.authorization.submit();
		}
		</script>	  
</body>
</html>