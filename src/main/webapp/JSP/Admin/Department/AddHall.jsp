<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hall</title>
</head>
<body>
<h1>Add Hall</h1>
<form action="../../../AdminHallServlet/AddHall" method="post">
<input type="text" name="hallname"/>
<input type="text" name="hallfloor"/>
<button type="submit">Add Hall</button>
</form>
</body>
</html>