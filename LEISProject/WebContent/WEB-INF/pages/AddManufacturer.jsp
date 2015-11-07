<html>
<body>

	<h1>${headerMessage}</h1>

	<h3> Add Manufacturer </h3>

	<form action="/LEISProject/manufacturer/submitAddManufacturer" method="post">
		<p>
			Manufacturer Name : <input type="text" name="manufacturerName" />
		</p>
		
		<input type="submit" value="Add" />
	</form>
 
</body>
</html>

