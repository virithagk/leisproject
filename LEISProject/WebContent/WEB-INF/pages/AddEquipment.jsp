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
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<title>Manage Equipments</title>

<style type="text/css">
#mainWrapper {
	width: 90%;
	height: 90%;
	margin-top: 1%;
	margin-bottom: 5%;
	margin-left: 5%;
	margin-right: 98%;
	border-radius: 25px;
	background-color: #FFE8BB;
	border: 1px solid #FFE8BB;
	border-top-style: outset;
	border-bottom-style: outset;
	border-right-style: outset;
	overflow: hidden; /* will contain if #first is longer than #second */
}

#inputWrapper {
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
	width: 100%;
	/*border: 1px solid black;*/
	/*overflow: hidden;*/
	/* will contain if #first is longer than #second */
	overflow: auto;
	overflow-y: hidden;
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
	/* Custom filtering function which will search data in column four between two values */
	$.fn.dataTable.ext.search.push(function(settings, data, dataIndex) {
		var min = parseInt($('#min').val(), 10);
		var max = parseInt($('#max').val(), 10);
		var age = parseFloat(data[9]) || 0; // use data for the age column

		if ((isNaN(min) && isNaN(max)) || (isNaN(min) && age <= max)
				|| (min <= age && isNaN(max)) || (min <= age && age <= max)) {
			return true;
		}
		return false;
	});

	$(document).ready(function() {
		var table = $('#example').DataTable({
			"scrollX" : true,
			"scrollY": "200px",
        "paging": true,
        "aLengthMenu": [[5, 10, 25, -1], [5, 10, 25, "All"]],
        "iDisplayLength": 5
		});
		
		$('a.toggle-vis').on('click', function(e) {
			e.preventDefault();

			// Get the column API object
			var column = table.column($(this).attr('data-column'));

			// Toggle the visibility
			column.visible(!column.visible());
		});

		// Event listener to the two range filtering inputs to redraw on input
		$('#min, #max').keyup(function() {
			table.draw();

		});
	});

	/* $(document).ready(function() {
		$('#example').dataTable();
	}); */
</script>


</head>

<body bgcolor='#B45353'>
<center>
<table width="100%" style="margin-left: 90px; margin-right: 60%" >
<tr>
	<td width="10%" bgcolor="#FFE8BB">
		<img src="<c:url value="/resources/images/UCM.jpg" />" height="170px" width="170px" alt="UCMO"></td>
		<td width="80%"bgcolor="#FFE8BB">
		<h1 align="left"><font face="Verdana" color="#C0152B">Lab Equipment Inventory System</font></h1>
		
	<h4 align="right">
	<font face="Verdana" color="#C0152B">Welcome ${curLogin.userName} ${curLogin.role} | <a href="showLogin.html">Logout</a></font>
	</h4>
	</td> </tr>
	
</tr>
</table>
</center>
	<div id='mainWrapper'>
		<div>
			<h1>${headerMessage}</h1>
		</div>
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
					<h2>Add New Equipment</h2>

					<form:form method="POST" action="/LEISProject/saveEquipment.html">
						<table>
							<tr>
								<td><form:label path="manufacturer.manufacturerId">Manufacturer Id:</form:label></td>
								<td><form:select path="manufacturer.manufacturerId"
										cssStyle="width: 210px;">
										<option value="-1">--Select a Manufacturer--</option>
										<c:forEach items="${manufacturers}" var="manufacturer">
											<option value="${manufacturer.manufacturerId}">${manufacturer.manufacturerName}</option>
										</c:forEach>
									</form:select></td>
								<!-- </tr>
			    <tr> -->
								<td><form:label path="equipmentType.typeCode">Equipment Type Code:</form:label></td>

								<td><form:select path="equipmentType.typeCode"
										cssStyle="width: 210px;">
										<option value="-1">--Select an Equipment Type--</option>
										<c:forEach items="${equipmentTypes}" var="equipmentType">
											<option value="${equipmentType.typeCode}">${equipmentType.typeName}</option>
										</c:forEach>
									</form:select></td>
								<!--  </tr>

				<tr> -->
								<td><form:label path="model.modelCode">Model Code:</form:label></td>
								<td><form:select path="model.modelCode"
										cssStyle="width: 210px;">
										<option value="-1">--Select a Model--</option>
										<c:forEach items="${models}" var="model">
											<option value="${model.modelCode}">${model.modelName}</option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="serialNumber">Serial Number:</form:label></td>
								<td><form:input path="serialNumber"
										value="${equipment.serialNumber}" cssStyle="width: 205px;" /></td>
								<!-- </tr>
				
				<tr> -->
								<td><form:label path="ucmInventoryNo">UCM Inventory Number:</form:label></td>
								<td><form:input path="ucmInventoryNo"
										value="${equipment.ucmInventoryNo}" cssStyle="width: 205px;" /></td>
								<!-- </tr>
			    <tr> -->
								<td><form:label path="cisInventoryNo">CIS Inventory Number :</form:label></td>
								<td><form:input path="cisInventoryNo"
										value="${equipment.cisInventoryNo}" cssStyle="width: 205px;" /></td>
							</tr>

							<tr>
								<td><form:label path="dateInstalled">Date Installed:</form:label></td>

								<td><form:input path="dateInstalled" id="dateInstalled"
										type="text" size="25" value="${equipment.dateInstalled}" /> <a
									href="javascript:NewCal('dateInstalled','ddmmyyyy')"> <img
										src="<c:url value="/resources/images/cal.gif" />" width="16"
										height="16" border="0" alt="Pick a date">
								</a></td>

								<%-- <td align="left">
			      	<form:errors path="dateInstalled" cssStyle="color:red"></form:errors>
			      </td>   --%>



								<%-- <td><form:input path="dateInstalled" value="${equipment.dateInstalled}"/></td> --%>
								<!-- </tr>
			    <tr> -->
								<td><form:label path="status.statusCode">Status Code:</form:label></td>
								<td><form:select path="status.statusCode"
										cssStyle="width: 210px;">
										<option value="-1">--Select a Status--</option>
										<c:forEach items="${statuses}" var="status">
											<option value="${status.statusCode}">${status.statusName}</option>
										</c:forEach>
									</form:select></td>
								<!-- </tr>
				
				<tr> -->
								<td><form:label path="fundingSource.fundingSourceId">Funding Source  ID :</form:label></td>
								<td><form:select path="fundingSource.fundingSourceId"
										cssStyle="width: 210px;">
										<option value="-1">--Select a Funding Source--</option>
										<c:forEach items="${fundingSources}" var="fundingSource">
											<option value="${fundingSource.fundingSourceId}">${fundingSource.agencyName}</option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="dateFunded">Date Funded:</form:label></td>
								<td><form:input path="dateFunded" id="dateFunded"
										type="text" size="25" value="${equipment.dateFunded}" /> <a
									href="javascript:NewCal('dateFunded','mmddyyyy')"> <img
										src="<c:url value="/resources/images/cal.gif" />" width="16"
										height="16" border="0" alt="Pick a date">
								</a></td>
								<!--  </tr>
				
				<tr> -->
								<td><form:label path="dateExpired">Date Expired :</form:label></td>
								<td><form:input path="dateExpired" id="dateExpired"
										type="text" size="25" value="${equipment.dateExpired}" /> <a
									href="javascript:NewCal('dateExpired','mmddyyyy')"> <img
										src="<c:url value="/resources/images/cal.gif" />" width="16"
										height="16" border="0" alt="Pick a date">
								</a></td>

								<!--  </tr>
				
				<tr> -->
								<td><form:label path="dateRemoved">Date Removed :</form:label></td>
								<td><form:input path="dateRemoved" id="dateRemoved"
										type="text" size="25" value="${equipment.dateRemoved}" /> <a
									href="javascript:NewCal('dateRemoved','mmddyyyy')"> <img
										src="<c:url value="/resources/images/cal.gif" />" width="16"
										height="16" border="0" alt="Pick a date">
								</a></td>

							</tr>
							<tr>
								<td><form:label path="dateCheckedOut">Date Checked Out:</form:label></td>
								<td><form:input path="dateCheckedOut" id="dateCheckedOut"
										type="text" size="25" value="${equipment.dateCheckedOut}" /> <a
									href="javascript:NewCal('dateCheckedOut','mmddyyyy')"> <img
										src="<c:url value="/resources/images/cal.gif" />" width="16"
										height="16" border="0" alt="Pick a date">
								</a></td>

								<!--  </tr>
				
				<tr> -->
								<td><form:label path="dateReturned">Date Returned:</form:label></td>
								<td><form:input path="dateReturned" id="dateReturned"
										type="text" size="25" value="${equipment.dateReturned}" /> <a
									href="javascript:NewCal('dateReturned','mmddyyyy')"> <img
										src="<c:url value="/resources/images/cal.gif" />" width="16"
										height="16" border="0" alt="Pick a date">
								</a></td>

								<!--  </tr>
				
				<tr> -->
								<td><form:label path="currentOwner">Current Owner :</form:label></td>
								<td><form:input path="currentOwner"
										value="${equipment.currentOwner}" cssStyle="width: 205px;" /></td>
							</tr>
							<tr>
								<td><form:label path="location.roomId">Room Number:</form:label></td>
								<td><form:select path="location.roomId"
										cssStyle="width: 210px;">
										<option value="-1">--Select a Location--</option>
										<c:forEach items="${locations}" var="location">
											<option value="${location.roomId}">${location.roomName}</option>
										</c:forEach>
									</form:select></td>

								<!--  </tr>
				
				<tr> -->
								<td><form:label path="purpose">Purpose:</form:label></td>
								<td><form:input path="purpose" value="${equipment.purpose}"
										cssStyle="width: 205px;" /></td>
								<!-- </tr>
				
				<tr> -->
								<td><form:label path="additionalComp">Additional Components:</form:label></td>
								<td><form:input path="additionalComp"
										value="${equipment.additionalComp}" cssStyle="width: 205px;" /></td>
							</tr>
							<tr>
								<td><form:label path="notes">Notes :</form:label></td>
								<td><form:input path="notes" value="${equipment.notes}"
										cssStyle="width: 205px;" /></td>
							</tr>
							<%-- 	<tr> --%>
							<tr>
								<td>&nbsp;</td>
								<td><input type="submit" value="SAVE" /></td>
							</tr>
						</table>
					</form:form>
				</div>
				<br />
			</div>
			<br>
			<div>

				<c:if test="${!empty equipments}">

					<div class="container">
						<table id="example" class="display nowrap" cellspacing="0" width="100%"
							align="center">
							<thead>
								<tr>
									<th>Equipment Id</th>
									<th>Manufacturer Id</th>
									<th>Equipment Type Code</th>
									<th>Model Code</th>
									<th>Serial Number</th>
									<th>UCM Inventory Number</th>
									<th>CIS Inventory Number</th>
									<th>Date Installed</th>
									<!-- <th>Status Code</th>
									<th>Funding Source ID</th> 
									<th>Date Funded</th>
									<th>Date Expired</th> 
									<th>Date Removed</th> 
									<th>Date Checked Out</th>
									<th>Date Returned</th>
									<th>Current Owner</th> -->
									<th>Room Number</th>
									<!-- <th>Purpose</th>
									<th>Additional Components</th>
									<th>Notes</th> -->
									<th>Options</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${equipments}" var="equipment">
									<tr>
										<td><c:out value="${equipment.equipmentId}" /></td>
										<td><c:out
												value="${equipment.manufacturer.manufacturerId}" /></td>
										<td><c:out value="${equipment.equipmentType.typeCode}" /></td>
										<td><c:out value="${equipment.model.modelCode}" /></td>
										<td><c:out value="${equipment.serialNumber}" /></td>
										<td><c:out value="${equipment.ucmInventoryNo}" /></td>
										<td><c:out value="${equipment.cisInventoryNo}" /></td>
										<td><c:out value="${equipment.dateInstalled}" /></td>
										<%-- <td><c:out value="${equipment.status.statusCode}" /></td>
										<td><c:out
												value="${equipment.fundingSource.fundingSourceId}" /></td>
										<td><c:out value="${equipment.dateFunded}" /></td>
										<td><c:out value="${equipment.dateExpired}" /></td>
										<td><c:out value="${equipment.dateRemoved}" /></td>
										<td><c:out value="${equipment.dateCheckedOut}" /></td>
										<td><c:out value="${equipment.dateReturned}" /></td>
										<td><c:out value="${equipment.currentOwner}" /></td> --%>
										<td><c:out value="${equipment.location.roomId}" /></td>
										<%-- <td><c:out value="${equipment.purpose}" /></td>
										<td><c:out value="${equipment.additionalComp}" /></td>
										<td><c:out value="${equipment.notes}" /></td> --%>
										<td><a
											href="editEquipment.html?equipmentId=${equipment.equipmentId}">Edit</a>
											| <a
											href="deleteEquipmentType.html?equipmentId=${equipment.equipmentId}">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div>
<b><font color="#800000">Show/Hide Column:</font>
<a href="#" class="toggle-vis" data-column="0" style="color: indigo; text-decoration:none;">Equipment Id</a> - 
<a href="#" class="toggle-vis" data-column="1" style="color: indigo; text-decoration:none;">Manufacturer Id</a> - 
<a href="#" class="toggle-vis" data-column="2" style="color: indigo; text-decoration:none;">Equipment Type Code</a> - 
<a href="#" class="toggle-vis" data-column="3" style="color: indigo; text-decoration:none;">Model Code</a> - 
<a href="#" class="toggle-vis" data-column="4" style="color: indigo; text-decoration:none;">Serial Number</a> - 
<a href="#" class="toggle-vis" data-column="5" style="color: indigo; text-decoration:none;">UCM Inventory Number</a>
<a href="#" class="toggle-vis" data-column="6" style="color: indigo; text-decoration:none;">CIS Inventory Number</a> - 
<a href="#" class="toggle-vis" data-column="7" style="color: indigo; text-decoration:none;">Date Installed</a> - 
<a href="#" class="toggle-vis" data-column="16" style="color: indigo; text-decoration:none;">Status Code</a> - 
<a href="#" class="toggle-vis" data-column="9" style="color: indigo; text-decoration:none;">Funding Source ID</a> - 
<a href="#" class="toggle-vis" data-column="10" style="color: indigo; text-decoration:none;">Date Funded</a> - 
<a href="#" class="toggle-vis" data-column="11" style="color: indigo; text-decoration:none;">Date Expired</a> - 
<a href="#" class="toggle-vis" data-column="12" style="color: indigo; text-decoration:none;">Date Removed</a> - 
<a href="#" class="toggle-vis" data-column="13" style="color: indigo; text-decoration:none;">Date Checked Out</a> - 
<a href="#" class="toggle-vis" data-column="14" style="color: indigo; text-decoration:none;">Date Returned</a> - 
<a href="#" class="toggle-vis" data-column="15" style="color: indigo; text-decoration:none;">Current Owner</a> - 
<a href="#" class="toggle-vis" data-column="8" style="color: indigo; text-decoration:none;">Room Number</a> - 
<a href="#" class="toggle-vis" data-column="17" style="color: indigo; text-decoration:none;">Purpose</a> - 
<a href="#" class="toggle-vis" data-column="18" style="color: indigo; text-decoration:none;">Additional Components</a> - 
<a href="#" class="toggle-vis" data-column="19" style="color: indigo; text-decoration:none;">Notes</a>
</b>
				</div>
				</c:if>

				<br />

				<br />
				<br />
		
			</div>

		</div>


	</div>
	</div>
	<!-- mainwrapper div -->

</body>
</html>
