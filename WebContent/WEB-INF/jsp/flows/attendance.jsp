<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="javax.servlet.http.HttpServletRequest" %>
    <%@ page import="com.qf.hrm.pojo.Attendance" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工考勤</title>
    <link href="${pageContext.request.contextPath}/css/css.css" type="text/css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
	<link href="${pageContext.request.contextPath}/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-migrate-1.2.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/core/base.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script> 
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
	<link href="${pageContext.request.contextPath}/css/pager.css" type="text/css" rel="stylesheet" />
</head>
<body>
<script type="text/javascript">
	function doAttendance(){
		 var sDate = $("#sDate").val();
		 if(sDate==null||sDate.length==0){
			 alert("签到日期不能为空");
			 return;
		 }
		/*  $.ajax({
			type:"get",
			date:{"sDate":sDate},
			url:"${pageContext.request.contextPath}/flows/doAttendance.action?sDate="+sDate,
			dateType:"json",
			 success: function(data){
				 alert(data);
              }
		 }) 
		 alert("签到成功") */
		 var url="${pageContext.request.contextPath}/flows/doAttendance.action?sDate="+sDate;
		 document.attendance.action=url;
		 document.attendance.submit();
		 
	}
	function doSignBack(){
		 var sDate = $("#checkAttendance").text();
		 var eDate = $("#eDate").val();
		 if(sDate==null||sDate.length==0){
			 alert("尚未签到,不能签退");
			 return;
		 }
		 if(eDate==null||eDate.length==0){
			 alert("签退日期不能为空");
			 return;
		 }
		/*  $.ajax({
				type:"get",
				date:{"eDate":eDate},
				url:"${pageContext.request.contextPath}/flows/signBack.action?eDate="+eDate,
				dateType:"json",
				 success: function(data){
					 alert(data);
	              }
			 }) 
			 alert("签退成功") */
		 var url="${pageContext.request.contextPath}/flows/signBack.action?eDate="+eDate;
		 document.signBack.action=url;
		 document.signBack.submit();
	}

</script>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="text-align:left" >
			  <tr><td height="10"></td></tr>
	  <tr>
	  	<td width="1%"></td>
	    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：流程管理 &gt; 员工考勤</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	<table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
	<tr class="main_trbg_tit" align="center"><td>考勤时间</td>
	<td class="font3" >操作</td></tr>
	<% String sDate = (String)request.getAttribute("sDate");
		if(sDate==null){
	%>
	<form method="post" id="attendance" name="attendance">
	<tr id="a1" class="main_trbg_tit"  align="center" > 
		<td class="font3" ><input Class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'});" 
					name="sDate" id="sDate" size="40"/></td>
	</form>
		<td class="font3" ><input type="button" id="doAttendance" value="签到" onClick="doAttendance()" ></input></td>
		</tr>
		<%}else{ %>
		<tr class="main_trbg_tit"  align="center" >
		<td class="font3" id="checkAttendance" >签到时间:&nbsp;&nbsp;<%=sDate %></td>
		</tr>
		<%} %>
		<% String eDate = (String)request.getAttribute("eDate");
			if(eDate==null){
	%>
		<form method="post" id="signBack" name="signBack">
		<tr id="a2" class="main_trbg_tit"  align="center" >
		<td  class="font3"><input Class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd HH:mm'});" 
					name="eDate" id="eDate" size="40"/></td>
		<td class="font3" ><input type="button" id="signBack" value="签退" onClick="doSignBack()"></input></td>
	   </tr>
	   </form>
	   <%}else{%>
		<tr class="main_trbg_tit"  align="center" >
		<td class="font3" >签退时间:&nbsp;&nbsp;<%=eDate%></td>
		<%} %>
	</tr>
	</table>
</body>

</html>