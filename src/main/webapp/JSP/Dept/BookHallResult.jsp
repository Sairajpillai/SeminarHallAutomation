<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
	<c:when test="${status eq 'success' }">
	<h1>Hall Request is sent to the Admin for Approval</h1>
	</c:when>
	<c:otherwise>
	<h1>You have already requested for the hall on that day</h1>
	</c:otherwise>
	</c:choose>
</body>
</html>-->

<%@ include file="/HTML/DeptHallbooking/DeptHallHeaderInside.html" %>
<div class="main-content">
<c:choose>
	<c:when test="${status eq 'success' }">
	<h1>Hall Request is sent to the Admin for Approval</h1>
	</c:when>
	<c:otherwise>
	<h1>You have already requested for the hall on that day</h1>
	</c:otherwise>
	</c:choose>
	</div>
	
	<%@ include file="/HTML/DeptHallbooking/DeptHallFooter.html" %>