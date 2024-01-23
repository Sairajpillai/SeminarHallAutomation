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
	<h1>Edit Department</h1>
	<c:choose>
		<c:when test="${dept ne null || ! empty dept }">
			<form action="./controller/EditDepartment" method="post">
				<table>
					<tr>
						<th>DEPT ID</th>
						<td><input type="text" name="deptid" readonly="readonly"
							value='${dept.deptId}' /></td>
					</tr>
					<tr>
						<th>DEPT NAME</th>
						<td><input type="text" name="deptname" value='${dept.deptname}' /></td>
					</tr>
					<tr>
						<th>DEPT HOD</th>
						<td><input type="text" name="depthod" value='${dept.depthod}' /></td>
					</tr>
					<tr>
						<th>DEPT BRANCH</th>
						<td><input type="text" name="deptbranch"
							value='${dept.deptbranch}' /></td>
					</tr>
					<tr>
						<th>DEPT PASSWORD</th>
						<td><input type="text" name="deptpassword"
							value='${dept.deptpassword}' /></td>
					</tr>
				</table>
				<button type="submit">Update Department</button>
			</form>
		</c:when>
	</c:choose>
</body>
</html>-->


<%@ include file="/HTML/Dept/DeptHeaderInside.html" %>
<div class="main-content">
    <div class="card">
<h1>Edit Department</h1>
	<c:choose>
		<c:when test="${dept ne null || ! empty dept }">
			<form action="./controller/EditDepartment" method="post">
				<table>
					<tr>
						<th>DEPT ID</th>
						<td><input type="text" name="deptid" readonly="readonly"
							value='${dept.deptId}' /></td>
					</tr>
					<tr>
						<th>DEPT NAME</th>
						<td><input type="text" name="deptname" value='${dept.deptname}' /></td>
					</tr>
					<tr>
						<th>DEPT HOD</th>
						<td><input type="text" name="depthod" value='${dept.depthod}' /></td>
					</tr>
					<tr>
						<th>DEPT BRANCH</th>
						<td><input type="text" name="deptbranch"
							value='${dept.deptbranch}' /></td>
					</tr>
					<tr>
						<th>DEPT PASSWORD</th>
						<td><input type="text" name="deptpassword"
							value='${dept.deptpassword}' /></td>
					</tr>
				</table>
				<button type="submit">Update Department</button>
			</form>
		</c:when>
	</c:choose>

</div>
</div>
<%@ include file="/HTML/Dept/DeptFooter.html" %>