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
<c:choose>
<c:when test="${dto eq null }">
<h1>You have not requested for any Hall.</h1>
</c:when>
<c:otherwise>
<c:forEach items="${dto}" var="halldto" >
Hall Id : ${halldto.hallid }<br/>
Hall Name : ${halldto.hallname }<br/>
Hall floor : ${halldto.hallfloor }<br/>
Hall Status : ${halldto.status }<br/>
Hall Booking Requested Date : ${halldto.halldate }<br/>
Hall Requested Date : ${halldto.requesteddate }<br/>
</c:forEach>
</c:otherwise>

</c:choose>
</body>
</html>-->


<%@ include file="/HTML/DeptHallbooking/DeptHallHeaderInside.html" %>
<div class="main-content">
<c:choose>
<c:when test="${dto eq null }">
<h1>You have not requested for any Hall.</h1>
</c:when>
<c:otherwise>
<c:forEach items="${dto}" var="halldto" >
Hall Id : ${halldto.hallid }<br/>
Hall Name : ${halldto.hallname }<br/>
Hall floor : ${halldto.hallfloor }<br/>
Hall Status : ${halldto.status }<br/>
Hall Booking Requested Date : ${halldto.halldate }<br/>
Hall Requested Date : ${halldto.requesteddate }<br/>
</c:forEach>
</c:otherwise>

</c:choose>

</div>

<%@ include file="/HTML/DeptHallbooking/DeptHallFooter.html" %>