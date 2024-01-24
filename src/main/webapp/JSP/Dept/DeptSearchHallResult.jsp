<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>View Hall</h1>
	<c:choose>
		<c:when test="${isAvailable eq false }">
	<h1>Hall is Not Available for booking on the given date</h1>
				<table>
					<tr>
						<th>HALL NAME</th>
						<td><input type="text" name="hallname" readonly="readonly" value='${dto.hallname}' /></td>
					</tr>
					<tr>
						<th>HALL FLOOR</th>
						<td><input type="text" name="hallfloor" readonly="readonly" value='${dto.hallfloor}' /></td>
					</tr>
					<tr>
						<th>HALL BOOKED DATE BY OTHER DEPT</th>
						<td><input type="text" name="halldate" readonly="readonly"
							value='${dto.bookeddate}' /></td>
					</tr>
					
				</table>
		</c:when>
		<c:otherwise>
	<h1>Hall is Available for booking on the given date</h1>
	<h2>Hall Details Are: </h2>
	<c:choose>
	<c:when test="${halldto ne null }">
	<form action="./controller/BookHall" method="post">
	<table>
					<tr>
						<th>HALL ID</th>
						<td><input type="text" name="hallid" readonly="readonly" value='${halldto.hallid}' /></td>
					</tr>
					<tr>
						<th>HALL NAME</th>
						<td><input type="text" name="hallname" readonly="readonly" value='${halldto.hallname}' /></td>
					</tr>
					<tr>
						<th>HALL FLOOR</th>
						<td><input type="text" name="hallfloor" readonly="readonly" value='${halldto.hallfloor}' /></td>
					</tr>
					
				</table>
				<button type="submit">Book Hall</button>
				</form>
	</c:when>
	<c:otherwise>
	<h1>You entered wrong hall name</h1>
	</c:otherwise>
	</c:choose>
	</c:otherwise>
	</c:choose>
	
</body>
</html>-->

<%@ include file="/HTML/DeptHallbooking/DeptHallHeaderInside.html" %>
<div class="main-content">
<h1>View Hall</h1>
	<c:choose>
		<c:when test="${isAvailable eq false }">
	<h1>Hall is Not Available for booking on the given date</h1>
				<table>
					<tr>
						<th>HALL NAME</th>
						<td><input type="text" name="hallname" readonly="readonly" value='${dto.hallname}' /></td>
					</tr>
					<tr>
						<th>HALL FLOOR</th>
						<td><input type="text" name="hallfloor" readonly="readonly" value='${dto.hallfloor}' /></td>
					</tr>
					<tr>
						<th>HALL BOOKED DATE BY OTHER DEPT</th>
						<td><input type="text" name="halldate" readonly="readonly"
							value='${dto.bookeddate}' /></td>
					</tr>
					
				</table>
		</c:when>
		<c:otherwise>
	<h1>Hall is Available for booking on the given date</h1>
	<h2>Hall Details Are: </h2>
	<c:choose>
	<c:when test="${halldto ne null }">
	<form action="./controller/BookHall" method="post">
	<table>
					<tr>
						<th>HALL ID</th>
						<td><input type="text" name="hallid" readonly="readonly" value='${halldto.hallid}' /></td>
					</tr>
					<tr>
						<th>HALL NAME</th>
						<td><input type="text" name="hallname" readonly="readonly" value='${halldto.hallname}' /></td>
					</tr>
					<tr>
						<th>HALL FLOOR</th>
						<td><input type="text" name="hallfloor" readonly="readonly" value='${halldto.hallfloor}' /></td>
					</tr>
					
				</table>
				<button type="submit">Book Hall</button>
				</form>
	</c:when>
	<c:otherwise>
	<h1>You entered wrong hall name</h1>
	</c:otherwise>
	</c:choose>
	</c:otherwise>
	</c:choose>
	
</div>
<%@ include file="/HTML/DeptHallbooking/DeptHallFooter.html" %>

