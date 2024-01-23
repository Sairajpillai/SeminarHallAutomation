<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking History</title>
</head>
<body>

	<c:choose>
		<c:when test="${dto ne null }">
			<c:forEach items="${dto}" var="dto">
					<table>
						<thead>
							<tr>
								<th>HALL BOOKING ID</th>
								<th>REQUESTED DATE</th>
								<th>HALL DATE</th>
								<th>DEPARTMENT NAME</th>
								<th>DEPARTMENT BRANCH</th>
								<th>HALL NAME</th>
								<th>HALL FLOOR</th>
								<th>BOOKING STATUS</th>
								<th>ADMIN NAME</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input readonly name="hallbookingid" value="${dto.hallbookingid}" /></td>
								<td><input readonly name="hallname"
									value="${dto.hallname}" /></td>
								<td><input readonly name="hallfloor"
									value="${dto.hallfloor}" /></td>
								<td><input readonly name="deptname"
									value="${dto.deptname}" /></td>
								<td><input readonly name="deptbranch"
									value="${dto.deptbranch}" /></td>
								<td><input readonly name="requesteddate"
									value="${dto.requesteddate}" /></td>
								<td><input readonly name="halldate"
									value="${dto.halldate}" /></td>
								<td><input readonly name="status"
									value="${dto.status}" /></td>
								<td><input readonly name="adminname"
									value="${dto.adminname}" /></td>
							</tr>
						</tbody>
					</table>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>No Records found</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>-->

<%@ include file="/HTML/HallApproval/HallApprovalHeader.html" %>
<div class="main-content">


	<c:choose>
		<c:when test="${dto ne null }">
			<c:forEach items="${dto}" var="dto">
					<table>
						<thead>
							<tr>
								<th>HALL BOOKING ID</th>
								<th>REQUESTED DATE</th>
								<th>HALL DATE</th>
								<th>DEPARTMENT NAME</th>
								<th>DEPARTMENT BRANCH</th>
								<th>HALL NAME</th>
								<th>HALL FLOOR</th>
								<th>BOOKING STATUS</th>
								<th>ADMIN NAME</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input readonly name="hallbookingid" value="${dto.hallbookingid}" /></td>
								<td><input readonly name="hallname"
									value="${dto.hallname}" /></td>
								<td><input readonly name="hallfloor"
									value="${dto.hallfloor}" /></td>
								<td><input readonly name="deptname"
									value="${dto.deptname}" /></td>
								<td><input readonly name="deptbranch"
									value="${dto.deptbranch}" /></td>
								<td><input readonly name="requesteddate"
									value="${dto.requesteddate}" /></td>
								<td><input readonly name="halldate"
									value="${dto.halldate}" /></td>
								<td><input readonly name="status"
									value="${dto.status}" /></td>
								<td><input readonly name="adminname"
									value="${dto.adminname}" /></td>
							</tr>
						</tbody>
					</table>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>No Records found</h1>
		</c:otherwise>
	</c:choose>



</div>
<%@ include file="/HTML/HallApproval/HallApprovalFooter.html" %>

