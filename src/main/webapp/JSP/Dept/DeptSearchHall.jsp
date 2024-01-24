<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Search Hall</h1>
<form action="../../DeptServlet/SearchHall">
<label>Search Hall</label>
<input type="text" name="hallname">
 <label for="datepicker">Select Date:</label>
        <input type="date" id="datepicker" name="selectedDate" min="<%= java.time.LocalDate.now() %>">
<button type="submit">Search Hall</button>
</form>
</body>
</html>-->

<%@ include file="/HTML/DeptHallbooking/DeptHallHeaderInside.html" %>
<div class="main-content">
<h1>Search Hall</h1>
<form action="../../DeptServlet/SearchHall">
<label>Search Hall</label>
<input type="text" name="hallname">
 <label for="datepicker">Select Date:</label>
        <input type="date" id="datepicker" name="selectedDate" min="<%= java.time.LocalDate.now() %>">
<button type="submit">Search Hall</button>
</form>

</div>




<%@ include file="/HTML/DeptHallbooking/DeptHallFooter.html" %>