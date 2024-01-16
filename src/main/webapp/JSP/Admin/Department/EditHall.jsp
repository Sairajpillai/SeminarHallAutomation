<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View Hall</h1>
	<c:choose>
		<c:when test="${hall ne null || ! empty hall }">
		<form action="./controller/EditHall" method="post">
				<table>
					<tr>
						<th>HALL ID</th>
						<td><input type="text" name="hallid" readonly="readonly"
							value='${hall.hallid}' /></td>
					</tr>
					<tr>
						<th>HALL NAME</th>
						<td><input type="text" name="hallname"  value='${hall.hallname}' /></td>
					</tr>
					<tr>
						<th>HALL LOCATION</th>
						<td><input type="text" name="hallfloor"  value='${hall.hallfloor}' /></td>
					</tr>
					<tr>
						<th>HALL ADDED DATE</th>
						<td><input type="text" name="halldate" readonly="readonly"
							value='${hall.cdate}' /></td>
					</tr>
					
					
				</table>
					<button type="submit">Update Hall</button>
					</form>
		</c:when>
		<c:otherwise>
	<h1>Hall Not Available</h1>
	</c:otherwise>
	</c:choose>
	
</body>
</html>