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
	<c:choose>
		<c:when test="${dto ne null }">
			<c:forEach items="${dto}" var="dto">
			<form action="../DeptServlet/DeleteBookingRequest" action="post">
					<table>
						<thead>
							<tr>
								<th>HALL BOOKING ID</th>
								<th>HALL DATE</th>
								<th>HALL NAME</th>
								<th>HALL FLOOR</th>
								<th>REQUESTED DATE</th>
								<th>STATUS</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input readonly name="hallbookingid" value="${dto.hallbookingid}" /></td>
								<td><input readonly name="halldate"
									value="${dto.halldate}" /></td>
								<td><input readonly name="hallname"
									value="${dto.hallname}" /></td>
								<td><input readonly name="hallfloor"
									value="${dto.hallfloor}" /></td>
								<td><input readonly name="requesteddate"
									value="${dto.requesteddate}" /></td>
								<td><input readonly name="status"
									value="${dto.status}" /></td>
									<td><input type="submit" value="Submit" name="action" /></td>
							</tr>
						</tbody>
					</table>
					</form>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>No requests are there for Deletion</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>