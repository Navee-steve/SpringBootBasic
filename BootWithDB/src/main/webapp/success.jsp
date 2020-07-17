<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>DATA SUCCESSFULLY PLACED</h1>
	<br>
	<hr>
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
		<input type="submit" value="HomePage" name="Homepage" />
	</form>
	<hr>
</body>
</html>