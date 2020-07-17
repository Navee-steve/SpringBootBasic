<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="fetchAction">
		ENTER THE ID WHICH NEED TO FETCH : <input type="text" name="id" required/><br> <br>
		<input type="submit" /><br>
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
</body>
</html>