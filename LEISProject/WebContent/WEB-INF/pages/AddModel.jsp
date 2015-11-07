<html>
<body>

	<h1>${headerMessage}</h1>

	<h3> Add Model</h3>

	<form action="/LEIS/model/submitAddModel" method="post">
		<p>
			Model Code: <input type="text" name="modelCode" />
			Model Name: <input type="text" name="modelName" />
			
		</p>
		
		<input type="submit" value="Add" />
	</form>
 
</body>
</html>