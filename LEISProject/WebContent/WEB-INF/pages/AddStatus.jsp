<html>
<body>

	<h1>${headerMessage}</h1>

	<h3> Add Status</h3>

	<form action="/LEIS/status/submitAddStatus" method="post">
		<p>
			Status Code: <input type="text" name="statusCode" />
			Status Name: <input type="text" name="statusName" />
			
		</p>
		
		<input type="submit" value="Add" />
	</form>
 
</body>
</html>