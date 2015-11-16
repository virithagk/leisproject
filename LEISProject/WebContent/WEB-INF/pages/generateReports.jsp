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
<title>Generate Reports</title>

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

function filterGlobal () {
    $('#example').DataTable().search(
        $('#global_filter').val(),
        $('#global_regex').prop('checked'),
        $('#global_smart').prop('checked')
    ).draw();
}
 
function filterColumn ( i ) {
    $('#example').DataTable().column( i ).search(
        $('#col'+i+'_filter').val(),
        $('#col'+i+'_regex').prop('checked'),
        $('#col'+i+'_smart').prop('checked')
    ).draw();
}
 

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

 $('input.global_filter').on( 'keyup click', function () {
        filterGlobal();
    } );
 
    $('input.column_filter').on( 'keyup click', function () {
        filterColumn( $(this).parents('tr').attr('data-column') );
    } );
		
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
					<h2>Search</h2>
<table cellpadding="2" cellspacing="0" border="0" style="width: 100%; margin: 0 auto 2em auto;">
        <thead>
            <tr>
                <th align ="left">Search Criteria</th>
                <th align ="left">Search Text</th>
                <!-- <th>Treat as regex</th>
                <th>Use smart search</th> -->
            </tr>
<tr><td></td></tr>
        </thead>
        <tbody>
            <tr id="filter_global">
                <td>Global search</td>
                <td align="center"><input type="text" class="global_filter" id="global_filter"></td>
<!--                 <td align="center"><input type="checkbox" class="global_filter" id="global_regex"></td>
                <td align="center"><input type="checkbox" class="global_filter" id="global_smart" checked="checked"></td> -->
            </tr>
            <tr id="filter_col1" data-column="16">
                <td>Room Number</td>
                <td align="center"><input type="text" class="column_filter" id="col0_filter"></td>
                <!-- <td align="center"><input type="checkbox" class="column_filter" id="col0_regex"></td>
                <td align="center"><input type="checkbox" class="column_filter" id="col0_smart" checked="checked"></td> -->
            </tr>
            <tr id="filter_col2" data-column="6">
                <td>CIS Inventory Number</td>
                <td align="center"><input type="text" class="column_filter" id="col1_filter"></td>
              <!--   <td align="center"><input type="checkbox" class="column_filter" id="col1_regex"></td>
                <td align="center"><input type="checkbox" class="column_filter" id="col1_smart" checked="checked"></td>
            --> </tr>
            <tr id="filter_col3" data-column="5">
                <td>UCM Inventory Number</td>
                <td align="center"><input type="text" class="column_filter" id="col2_filter"></td>
               <!--  <td align="center"><input type="checkbox" class="column_filter" id="col2_regex"></td>
                <td align="center"><input type="checkbox" class="column_filter" id="col2_smart" checked="checked"></td>
            --> </tr>
            <tr id="filter_col4" data-column="4">
                <td>Serial Number</td>
                <td align="center"><input type="text" class="column_filter" id="col3_filter"></td>
              <!--   <td align="center"><input type="checkbox" class="column_filter" id="col3_regex"></td>
                <td align="center"><input type="checkbox" class="column_filter" id="col3_smart" checked="checked"></td>
            --> </tr>
            <tr id="filter_col5" data-column="1">
                <td>Manufacturer Name</td>
                <td align="center"><input type="text" class="column_filter" id="col4_filter"></td>
               <!--  <td align="center"><input type="checkbox" class="column_filter" id="col4_regex"></td>
                <td align="center"><input type="checkbox" class="column_filter" id="col4_smart" checked="checked"></td>
            --> </tr>
            <tr id="filter_col6" data-column="3">
                <td>Model Name</td>
                <td align="center"><input type="text" class="column_filter" id="col5_filter"></td>
              <!--   <td align="center"><input type="checkbox" class="column_filter" id="col5_regex"></td>
                <td align="center"><input type="checkbox" class="column_filter" id="col5_smart" checked="checked"></td>
            --> </tr></b>
        </tbody>
    </table>

					<%-- <form:form method="POST" action="/LEISProject/saveEquipment.html">
					</form:form> --%>
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
									<th>Status Code</th>
									<th>Funding Source ID</th>
									<th>Date Funded</th>
									<th>Date Expired</th>
									<th>Date Removed</th>
									<th>Date Checked Out</th>
									<th>Date Returned</th>
									<th>Current Owner</th>
									<th>Room Number</th>
									<th>Purpose</th>
									<th>Additional Components</th>
									<th>Notes</th>
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
										<td><c:out value="${equipment.status.statusCode}" /></td>
										<td><c:out
												value="${equipment.fundingSource.fundingSourceId}" /></td>
										<td><c:out value="${equipment.dateFunded}" /></td>
										<td><c:out value="${equipment.dateExpired}" /></td>
										<td><c:out value="${equipment.dateRemoved}" /></td>
										<td><c:out value="${equipment.dateCheckedOut}" /></td>
										<td><c:out value="${equipment.dateReturned}" /></td>
										<td><c:out value="${equipment.currentOwner}" /></td>
										<td><c:out value="${equipment.location.roomId}" /></td>
										<td><c:out value="${equipment.purpose}" /></td>
										<td><c:out value="${equipment.additionalComp}" /></td>
										<td><c:out value="${equipment.notes}" /></td>
										<td><a
											href="editEquipment.html?equipmentId=${equipment.equipmentId}">Edit</a>
											| <a
											href="deleteEquipmentType.html?equipmentId=${equipment.equipmentId}">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

				</c:if>

				<br />
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
<a href="#" class="toggle-vis" data-column="8" style="color: indigo; text-decoration:none;">Status Code</a> - 
<a href="#" class="toggle-vis" data-column="9" style="color: indigo; text-decoration:none;">Funding Source ID</a> - 
<a href="#" class="toggle-vis" data-column="10" style="color: indigo; text-decoration:none;">Date Funded</a> - 
<a href="#" class="toggle-vis" data-column="11" style="color: indigo; text-decoration:none;">Date Expired</a> - 
<a href="#" class="toggle-vis" data-column="12" style="color: indigo; text-decoration:none;">Date Removed</a> - 
<a href="#" class="toggle-vis" data-column="13" style="color: indigo; text-decoration:none;">Date Checked Out</a> - 
<a href="#" class="toggle-vis" data-column="14" style="color: indigo; text-decoration:none;">Date Returned</a> - 
<a href="#" class="toggle-vis" data-column="15" style="color: indigo; text-decoration:none;">Current Owner</a> - 
<a href="#" class="toggle-vis" data-column="16" style="color: indigo; text-decoration:none;">Room Number</a> - 
<a href="#" class="toggle-vis" data-column="17" style="color: indigo; text-decoration:none;">Purpose</a> - 
<a href="#" class="toggle-vis" data-column="18" style="color: indigo; text-decoration:none;">Additional Components</a> - 
<a href="#" class="toggle-vis" data-column="19" style="color: indigo; text-decoration:none;">Notes</a>
</b>
				</div>
				<br />
				<br />
		
			</div>

		</div>


	</div>
	</div>
	<!-- mainwrapper div -->

</body>
</html>
