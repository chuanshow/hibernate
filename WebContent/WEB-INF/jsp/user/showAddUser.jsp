<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<title>企业员工信息管理系统——添加用户</title>
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
	
	<%String msg =(String)request.getAttribute("reasult"); 
		if("true".equals(msg)){
			%>
	<script type="text/javascript">
	$(function(){
		alert("添加成功")
		})
	</script>
	<%} else if("false".equals(msg)){%>
	<script type="text/javascript">
	$(function(){
		alert("添加失败,用户已存在")
		})
	</script>
	<%} %>
	<script type="text/javascript">
	$(function(){
    	/** 员工表单提交 */
		$("#userForm").submit(function(){
			var userName = $("#userName");
			var uStatus = $("#uStatus");
			var loginName = $("#loginName");
			var uPassword = $("#uPassword");
			var msg = "";
			if ($.trim(userName.val()) == ""){
				msg = "姓名不能为空！";
				userName.focus();
			}else if ($.trim(uStatus.val()) == ""){
				msg = "状态不能为空！";
				uStatus.focus();
			}else if ($.trim(loginName.val()) == ""){
				msg = "登录名不能为空！";
				loginName.focus();
			}else if ($.trim(uPassword.val()) == ""){
				msg = "密码不能为空！";
				uPassword.focus();
			}
			if (msg != ""){
				$.ligerDialog.error(msg);
				return false;
			}else{
				return true;
			}
			$("#userForm").submit();
		});
    });
	</script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr><td height="10"></td></tr>
  <tr>
    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
	<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：用户管理  &gt; 添加用户</td>
	<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
  </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
  <tr valign="top">
    <td>
    	 <form action="${pageContext.request.contextPath}/user/addUser1.action" id="userForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
    	 	<input type="hidden" name="flag" value="2">
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">姓&nbsp;名：<input type="text" name="userName" id="userName" size="20"/></td>
		    			<td class="font3 fftd">状&nbsp;态：<input type="text" name="uStatus" id="uStatus" size="20"/></td>
		    		</tr>
		    			
		    		<tr>
		    			<td class="font3 fftd">登录名：<input name="loginName" id="loginName" size="20" /></td>
		    			<td class="font3 fftd">密&nbsp;码：<input name="uPassword" id="uPassword" size="20" /></td>
		    		</tr>
					<%-- <tr><td><font color="red"><%=msg%></font> </td></tr> --%>
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			<tr><td align="left" class="fftd"><input type="submit" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	</td>
  </tr>
</table>
</body>
</html>