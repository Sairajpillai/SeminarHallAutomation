<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department Home Page</title>
</head>
<body>
<c:choose>
<c:when test="${ isDept eq true}">
<h1>Welcome ${deptname}</h1>
<a href="../JSP/Dept/DeptSearchHall.jsp">Check Hall Availability</a>
<!--  <a href="../JSP/Dept/DeptBookHall.jsp">Book Hall</a>
<a href="../JSP/Dept/DeptHallStatus.jsp">Hall booking Status</a>-->
<a href="../DeptServlet/BookingStatus">Hall booking Status</a>
<a href="../JSP/Dept/UpdateDepartment.jsp">Hall History</a>
<a href="../JSP/Dept/DeleteDepartment.jsp">View Account</a>
</c:when>
<c:otherwise>
<h1>
Invalid Username or Password
</h1>
</c:otherwise>
</c:choose>
</body>
</html>