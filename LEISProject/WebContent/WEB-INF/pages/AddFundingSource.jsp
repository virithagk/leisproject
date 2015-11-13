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
   <link rel="stylesheet" href="../css/styles.css">
   <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   <script src="../js/script.js"></script>
   <title>Manage Funding Sources</title>

<style type="text/css">
#mainWrapper {
    width: 80%;
    height:80%;
    margin-top:5%;
    margin-bottom:5%;
    margin-left:5%;
    margin-right:5%;
    border-radius: 25px;
    background-color:#FFE8BB;
    border: 1px solid #FFE8BB;
    border-top-style:outset;
    border-bottom-style:outset;
    border-right-style:outset;
    
    overflow: hidden; /* will contain if #first is longer than #second */
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

</head>

<body bgcolor='#FFCC66'>

<div id='mainWrapper'>
<div>
<h1>${headerMessage}</h1>
</div>
<div id='wrapper'>
<div id='first'>

<div id='cssmenu'>
<ul>
   <li class='active'><a href='#'><span><b>LEIS Home</b></span></a></li>
   <li class='has-sub'><a href='#'><span>Profile Actions</span></a>
      <ul>
         <li><a href='#'><span>My Profile</span></a></li>
         <li><a href='#'><span>Change my Password</span></a></li>
         <li class='last'><a href='#'><span>Reset User Password</span></a></li>
      </ul>
   </li>
   <li class='has-sub'><a href='#'><span>Admin Actions</span></a>
      <ul>
        <li><a href='addManufacturer.html'><span>Manage Manufacturers</span></a></li>
         <li><a href='addEquipmentType.html'><span>Manage Equipment Types</span></a></li>
         <li><a href='addFundingSource.html'><span>Manage Funding Sources</span></a></li>
         <li><a href='addLocation.html'><span>Manage Locations</span></a></li>
         <li><a href='addPlatformType.html'><span>Manage Platform Types</span></a></li>
         <li><a href='addModel.html'><span>Manage Models</span></a></li>
         <li class='last'><a href='addStatus.html'><span>Manage Status</span></a></li>
      </ul>
   </li>
   <li class='has-sub'><a href='#'><span>User Actions</span></a>
      <ul>
         <li><a href='#'><span>Manage Equipment</span></a></li>
         <li class='last'><a href='#'><span>Generate Reports</span></a></li>
      </ul>
   </li>
</ul>
</div>

</div>

<div id='second'>
<div>
<center>
		<h2>Add New Funding Source</h2>
		
		<form:form method="POST" action="/LEISProject/saveFundingSource.html">
	   		<table>
			    <tr>
			        <td><form:label path="agencyName">Agency Name :</form:label></td>
			        <td><form:input path="agencyName" value="${fundingSource.agencyName}"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="program">Program :</form:label></td>
			        <td><form:input path="program" value="${fundingSource.program}"/></td>
			    </tr>
			    
			   	<tr>
			    <tr>
			    	<td>&nbsp;</td>
			      <td><input type="submit" value="SAVE"/></td>
		      	</tr>
			</table> 
		</form:form>
		<br/>
  <c:if test="${!empty fundingSources}">
	<table align="center" border="1">
		<tr>
			<th>Funding Source Id</th>
			<th>Funding Source Name</th>
			<th>Funding Source Program</th>
			<th>Options</th>
		</tr>

		<c:forEach items="${fundingSources}" var="fundingSource">
			<tr>
				<td><c:out value="${fundingSource.fundingSourceId}"/></td>
				<td><c:out value="${fundingSource.agencyName}"/></td>
				<td><c:out value="${fundingSource.program}"/></td>
				<td align="center"><a href="editFundingSource.html?fundingSourceId=${fundingSource.fundingSourceId}">Edit</a> | <a href="deleteFundingSource.html?fundingSourceId=${fundingSource.fundingSourceId}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>

	
</div>
</div>
</div>

</div><!-- mainwrapper div -->

</body>
</html>