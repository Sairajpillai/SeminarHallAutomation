<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<c:when test="${result eq 'success' }">
<h1>Record Updated Successfully</h1>

</c:when>
<c:otherwise>
<h1>Record not updated Successfully</h1>

</c:otherwise>
</c:choose>
</body>
</html>-->

<%@ include file="/HTML/Dept/DeptHeaderInside.html" %>
<div class="main-content">
    <div class="card">
<c:choose>
<c:when test="${result eq 'success' }">
<h1>Record Updated Successfully</h1>

</c:when>
<c:otherwise>
<h1>Record not updated Successfully</h1>

</c:otherwise>
</c:choose>
</div>
</div>
<%@ include file="/HTML/Dept/DeptFooter.html" %>