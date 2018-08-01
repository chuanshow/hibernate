<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<title>申请流程</title>
</head>
<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0" style="text-align:left" >
			  <tr><td height="10"></td></tr>
	  <tr>
	  	<td width="1%"></td>
	    <td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locleft.gif" width="15" height="32"></td>
		<td class="main_locbg font2"><img src="${pageContext.request.contextPath}/images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：流程管理 &gt; 申请流程</td>
		<td width="15" height="32"><img src="${pageContext.request.contextPath}/images/main_locright.gif" width="15" height="32"></td>
	  </tr>
	</table>
	 <form action="${pageContext.request.contextPath}/addFlows.action" id="flowsForm" method="post">
    	 	<!-- 隐藏表单，flag表示添加标记 -->
		  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab" style="text-align:left">
		    <tr><td class="font3 fftd">
		    	<table>
		    		<tr>
		    			<td class="font3 fftd">流程名称：
		    				<select name="fName" id="fName" style="width:143px;"  >
		    					<option value="" disabled selected>请选择请假类型</option>
		    					<option value="病假">病假</option>
		    					<option value="事假">事假</option>
		    					<option value="婚假">婚假</option>
		    					<option value="因公外出">因公外出</option>
		    					<option value="出差">出差</option>
		    				</select></td>
		    			
		    		 	<!-- <input type="text" name="fName" id="fName" size="20"/></td>  -->
		    			<td class="font3 fftd">流程内容：<input type="text" name="context" id="context" size="20"/></td>
		    		</tr>
		    		<tr>
		    			<td class="font3 fftd">流程开始时间 <input Class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
					name="sDate" id="sDate" size="20"/></td>
		    			<td class="font3 fftd">流程结束时间 <input Class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'});" 
					name="eDate" id="eDate" size="20"/></td>
		    		</tr>
		    	</table>
		    </td></tr>
			<tr><td class="main_tdbor"></td></tr>
			
			<tr><td align="left" class="fftd"><input type="submit" value="申请 ">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
		  </table>
		 </form>
	
</body>
</html> 