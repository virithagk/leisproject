<html>
<body>

	<h1>${headerMessage}</h1>

	<h3> Add Equipment</h3>

	<form action="/LEIS/equipment/submitAddEquipment" method="post">
		<p>
			Manufacturer Id: <input type="text" name="manufacturerId" />
			Type Code: <input type="text" name="typeCode" />
			Model Code: <input type="text" name="modelCode" />
			Serial Number: <input type="text" name="serialNumber" />
			UCM Inventory Number: <input type="text" name="ucmInvNumber" />
			CIS Inventory Number : <input type="text" name="cisInvNumber" />
			
			Date Installed: <input type="text" name="dateInstalled" />
			Status Code: <input type="text" name="statusCode" />
			Funding Source  ID : <input type="text" name="fundingSourceId" />
			
			Date Funded: <input type="text" name="dateFunded" />
			Date Expired : <input type="text" name="dateExpired" />
			Date Removed : <input type="text" name="dateRemoved" />
			
			Date Checked Out: <input type="text" name="dateCheckedOut" />
			Date Returned: <input type="text" name="dateReturned" />
			Current Owner : <input type="text" name="currentOwner" />
			
			Room Number: <input type="text" name="roomNumber" />
			Purpose: <input type="text" name="purpose" />
			Additional Components : <input type="text" name="additionalComp" />
			Notes: <input type="text" name="notes" />
		</p>
		
		<input type="submit" value="Add" />
	</form>
 
</body>
</html>