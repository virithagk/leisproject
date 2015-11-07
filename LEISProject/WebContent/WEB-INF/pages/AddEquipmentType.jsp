<html>
<body>

	<h1>${headerMessage}</h1>

	<h3> Add Equipment Type </h3>

	<form action="/LEIS/equipmenttype/submitAddEquipmentType" method="post">
		<p>
			Type Code : <input type="text" name="typeCode" />
			Type Name : <input type="text" name="typeName" />
			
		</p>
		
		<input type="submit" value="Add" />
	</form>
 
</body>
</html>