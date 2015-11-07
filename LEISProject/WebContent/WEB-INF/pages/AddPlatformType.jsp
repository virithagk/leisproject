<html>
<body>

	<h1>${headerMessage}</h1>

	<h3> Add Platform</h3>

	<form action="/LEIS/platform/submitAddPlatform" method="post">
		<p>
			Platform Code: <input type="text" name="platformCode" />
			Platform Name: <input type="text" name="platformName" />
			
		</p>
		
		<input type="submit" value="Add" />
	</form>
 
</body>
</html>