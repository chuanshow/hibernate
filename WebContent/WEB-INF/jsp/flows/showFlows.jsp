<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${pageContext.request.contextPath}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-migrate-1.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
<title>流程查询</title>
</head>
<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	  <tr><td height="10"></td></tr>
	  <tr>
	    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：流程控制 &gt; 流程查询</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	 <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
		    <tr>
			  <td class="fftd">
			  	<form name="flowsForm" method="post" id="flowsForm" action="${pageContext.request.contextPath}/flows/selectFlows.action">
				    <table width="100%" border="0" cellpadding="0" cellspacing="0">
					  <tr>
					    <td class="font3">
					    	流程名：<input type="text" name="fName">
					    	 <input type="submit" value="搜索"/>
					    </td>
					  </tr>
					</table>
				</form>
			  </td>
			</tr>
		  </table>
	<table id="flows" width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
		<tr>
			<!-- <td><input type="checkBox" id="checkAll" ></td> -->
			 <td class="font3">流程名</td>
			  <td class="font3">流程开始时间</td>
			   <td class="font3">流程结束时间</td>
			   <td class="font3">流程状态</td>
			    <td class="font3">流程提出人</td>
			   <td class="font3">拒絕理由</td>
		</tr>
		<c:forEach items="${requestScope.flows}" var="flows" varStatus="stat">
			<tr>
		<%-- 	<td><input type="checkBox" id="fId" value="${flows.fId}"></td> --%>
			<td class="font3">${flows.fName}</td>
			<td class="font3">${flows.sDate}</td>
			<td class="font3">${flows.eDate}</td>
			<td class="font3"><c:choose>
							<c:when test="${flows.state == 1}">
							          待审批
							</c:when>
							<c:when test="${flows.state == 2}">
							          审批通过
							</c:when>
							<c:when test="${flows.state == 3}">
							          审批拒绝
							</c:when>
						</c:choose></td>
				<td class="font3">${flows.uName} </td>
				<td class="font3">${flows.reason} </td>
					  </tr>
		</c:forEach>
	</table>
</body>
</html>