<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Department</h1>
<form action="../../AdminServlet/addDepartment" method="post">
<input type="text" name="deptName"/>
<input type="text" name="deptHODName"/>
<input type="text" name="deptBranch"/>
<button type="submit">Add Department</button>
</form>
</body>
</html>-->

<%@ include file="/HTML/Dept/DeptHeader.html" %>
<div class="main-content">
    <div class="card">
 <form action="../../AdminServlet/addDepartment" method="post">
            <input type="text" name="deptName" placeholder="Department Name"/>
            <input type="text" name="deptHODName" placeholder="HOD Name"/>
            <input type="text" name="deptBranch" placeholder="Department Branch"/>
            <button type="submit">Add Department</button>
        </form>
</div>
</div>
<%@ include file="/HTML/Dept/DeptFooter.html" %>