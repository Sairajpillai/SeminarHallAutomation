<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Hall</h1>
<form action="../../../AdminHallServlet/UpdateHall">
<label>Update Hall</label>
<input type="text" name="hallname">
<button type="submit">Update Department</button>
</form>
</body>
</html>-->

<%@ include file="/HTML/Hall/HallHeader.html" %>
<div class="main-content">
    <div class="card">
    <h1>Edit Hall</h1>
<form action="../../../AdminHallServlet/UpdateHall">
<label>Update Hall</label>
<input type="text" name="hallname">
<button type="submit">Update Department</button>
</form>
    </div>
    </div>
    <%@ include file="/HTML/Hall/HallFooter.html" %>