<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="taglib_includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="css/styles.css">
<script src="js/script.js"></script>

<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/script.js" />"></script>
<script src="<c:url value="/resources/js/datetimepicker.js" />"></script>
<title>Manage Equipments</title>

<style type="text/css">
#mainWrapper {
	width: 90%;
	height: 90%;
	margin-top: 5%;
	margin-bottom: 5%;
	margin-left: 5%;
	margin-right: 95%;
	border-radius: 25px;
	background-color: #FFE8BB;
	border: 1px solid #FFE8BB;
	border-top-style: outset;
	border-bottom-style: outset;
	border-right-style: outset;
	overflow: hidden; /* will contain if #first is longer than #second */
}

#inputWrapper {
width: 15%;
	border-radius: 25px;
	background-color: #FCB563;
	border: 1px solid #FCB563;
	border-top-style: outset;
	border-bottom-style: outset;
	border-right-style: outset;
}

#bodybg {
	background: #666633;
	/* background: -moz-linear-gradient(#e94f31 0%, #d13516 100%);
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #e94f31), color-stop(100%, #d13516));
  background: -webkit-linear-gradient(#e94f31 0%, #d13516 100%);
  background: linear-gradient(#e94f31 0%, #d13516 100%);*/
	
}

#wrapper {
	width: 80%;
	/*border: 1px solid black;*/
	overflow: hidden; /* will contain if #first is longer than #second */
}

#first {
	width: 25%;
	float: left; /* add this */
	/*border: 1px solid red;*/
}

#second { /*border: 1px solid green;*/
	float: left;
	/*overflow: hidden;*/
	/* if you don't want #second to wrap below #first */
}
</style>

<link rel="stylesheet" type="text/css"
	href="<c:url value="https://cdn.datatables.net/r/ju-1.11.4/jqc-1.11.3,dt-1.10.8/datatables.min.css" />" />

<script type="text/javascript"
	src="<c:url value="https://cdn.datatables.net/r/ju-1.11.4/jqc-1.11.3,dt-1.10.8/datatables.min.js" />"></script>
<script type="text/javascript" charset="utf-8">
	$(document).ready(function() {
		$('#example').dataTable();
	});
</script>


</head>

<body bgcolor='#B45353'>
<br /><br /><br /><br /><br /><br />
<CENTER>
		<div>
			<h1>${headerMessage}</h1>
		</div>
				<div id='inputWrapper'>
					<h3 align="left" ><font color="#800000">LEIS Login</font></h3>
					
					<font color="red">${errorMsg}<br /></font>
					<form:form method="POST" action="/LEISProject/validateLogin.html">
						<table>

							<tr>
								<td><form:label path="userName">Username</form:label></td>
								<td><form:input path="userName"
										value="${login.userName}" /></td>
							</tr>
							<tr>
								<td><form:label path="password">Password</form:label></td>
								<td><form:input type="password" path="password"
										value="${login.password}" /></td>
							</tr>
							<tr>
			    				<td>&nbsp;</td>
			      				<td><input type="submit" value="Login"/></td>
			      					<td>&nbsp;</td>
		      				</tr>
						</table>
					</form:form>
				</div>
</CENTER>
</body>
</html>
