<html>
<body>

	<h1>${headerMessage}</h1>

	<h3> Add New Room</h3>

	<form action="/LEIS/location/submitAddLocation" method="post">
		<p>
			Room Number: <input type="text" name="roomNumber" />
			
			
		</p>
		
		<input type="submit" value="Add" />
	</form>
 
</body>
</html>