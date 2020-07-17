<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<h1>${members}</h1>
	<hr>
	<br>
	<form action="insert.jsp">
		<input type="submit" value="Insert" name="Insert" />
	</form>
	<br>
	<form action="fetchData.jsp">
		<input type="submit" value="Fetch" name="Fetch" />
	</form>
	<br>
	<form action="update.jsp">
		<input type="submit" value="Update" name="Update" />
	</form>
	<br>
	<form action="delete.jsp">
		<input type="submit" value="Delete" name="Delete" />
	</form>
	<br>
	<form action="home.jsp">
		<input type="submit" value="Home" name="HomePage" />
	</form>
</body>
</html>