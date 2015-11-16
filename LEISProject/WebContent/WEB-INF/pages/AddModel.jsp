<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset='utf-8'>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <link rel="stylesheet" href="css/styles.css">
   <script src="js/script.js"></script>
   
   <link href="<c:url value="/resources/css/styles.css" />" rel="stylesheet">
   <script src="<c:url value="/resources/js/script.js" />"></script>
    

   <title>Manage Models</title>

<style type="text/css">
#mainWrapper {
    width: 90%;
    height:90%;
    margin-top:2%;
    margin-bottom:2%;
    margin-left:2%;
    margin-right:100%;
    border-radius: 25px;
    background-color:#FFE8BB;
    border: 1px solid #FFE8BB;
    border-top-style:outset;
    border-bottom-style:outset;
    border-right-style:outset;
    
    overflow: hidden; /* will contain if #first is longer than #second */
}
#inputWrapper {
    border-radius: 25px;
    background-color:#FCB563;
    border: 1px solid #FCB563;
    border-top-style:outset;
    border-bottom-style:outset;
    border-right-style:outset;
}
#bodybg {
background: #666633;
 /* background: -moz-linear-gradient(#e94f31 0%, #d13516 100%);
  background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #e94f31), color-stop(100%, #d13516));
  background: -webkit-linear-gradient(#e94f31 0%, #d13516 100%);
  background: linear-gradient(#e94f31 0%, #d13516 100%);*/x	
}
#wrapper {
    width: 80%;
    /*border: 1px solid black;*/
    overflow: hidden; /* will contain if #first is longer than #second */
}
#first {
    width: 25%;
    float:left; /* add this */
    /*border: 1px solid red;*/
}
#second {
	
    /*border: 1px solid green;*/
    float: left; 
    /*overflow: hidden;*/ /* if you don't want #second to wrap below #first */
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
<table width="100%" style="margin-left: 10">
<tr>
	<td width="10%">
		<img src="<c:url value="/resources/images/UCM.jpg" />" height="170px" width="170px" alt="UCMO">
	</td>
	<td bgcolor="#C0152B">
<h1><font face="Verdana" color="#FFE8BB">Lab Equipment Inventory System</font></h1>
</td>
</tr>
</table>

<div id='mainWrapper'>
<h4 align="right">Welcome ${curLogin.userName} ${curLogin.role} | <a href="showLogin.html">Logout</a></h4>
<div id='wrapper'>
<div id='first'>

				<div id='cssmenu'>
					<ul>
						<li class='active'><a href='#'><span><b>LEIS
										Home</b></span></a></li>
						<li class='has-sub'><a href='#'><span>Profile
									Actions</span></a>
							<ul>
								<!-- <li><a href='#'><span>My Profile</span></a></li> -->
								<li><a href='changePassword.html'><span>Change my Password</span></a></li>
								<li><span></span></li>
								<li><a href='manageUsers.html'><span>Manage Users</span></a></li>
								<!-- <li class='last'><a href='#'><span>Reset User
											Password</span></a></li> -->
							</ul></li>
						<li class='has-sub'><a href='#'><span>Admin
									Actions</span></a>
							<ul>
								<li><a href='addManufacturer.html'><span>Manage
											Manufacturers</span></a></li>
								<li><a href='addEquipmentType.html'><span>Manage
											Equipment Types</span></a></li>
								<li><a href='addFundingSource.html'><span>Manage
											Funding Sources</span></a></li>
								<li><a href='addLocation.html'><span>Manage
											Locations</span></a></li>
								<li><a href='addPlatformType.html'><span>Manage
											Platform Types</span></a></li>
								<li><a href='addModel.html'><span>Manage Models</span></a></li>
								<li class='last'><a href='addStatus.html'><span>Manage
											Status</span></a></li>
							</ul></li>
						<li class='has-sub'><a href='#'><span>User Actions</span></a>
							<ul>
								<li><a href='addEquipment.html'><span>Manage
											Equipment</span></a></li>
								<li class='last'><a href='showReports.html'><span>Generate
											Reports</span></a></li>
							</ul></li>
					</ul>
				</div>
</div>

<div id='second'>
<div id='inputWrapper'>
<div>
<center>
		<h2>Add New Model</h2>
		
		<form:form method="POST" action="/LEISProject/saveModel.html">
	   		<table>
			    <tr>
			        <td><form:label path="modelCode">Model Code:</form:label></td>
			        <td><form:input path="modelCode" readonly="false"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="modelName">Model Name:</form:label></td>
			        <td><form:input path="modelName" value="${model.modelName}"/></td>
			    </tr>
			    
			   	<tr>
			    <tr>
			    	<td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      	</tr>
			</table> 
		</form:form></div>
		<br/>
  <c:if test="${!empty models}">
								<div class="container">

								<table id="example" class="display" cellspacing="0" width="100%" align="center">
									<thead>

		<tr>
			<th>Model Code</th>
			<th>Model Name</th>
			<th>Options</th>
		</tr>
</thead>
<tbody>
		<c:forEach items="${models}" var="model">
			<tr>
				<td><c:out value="${model.modelCode}"/></td>
				<td><c:out value="${model.modelName}"/></td>
				<td align="center"><a href="editModel.html?modelCode=${model.modelCode}">Edit</a> | <a href="deleteModel.html?modelCode=${model.modelCode}">Delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</c:if>

	
</div>
</div>
</div>

</div><!-- mainwrapper div -->

</body>
</html>
