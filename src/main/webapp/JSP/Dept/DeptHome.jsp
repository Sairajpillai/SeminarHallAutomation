<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<a href="../JSP/Dept/DeptSearchHall.jsp">Check Hall Availability</a>-->
<!--  <a href="../JSP/Dept/DeptBookHall.jsp">Book Hall</a>
<a href="../JSP/Dept/DeptHallStatus.jsp">Hall booking Status</a>-->
<!--  <a href="../DeptServlet/BookingStatus">Hall booking Status</a>
<a href="../DeptServlet/HallHistory">Hall History</a>
<a href="../DeptServlet/DeleteRequest">Hall Request</a>
</c:when>
<c:otherwise>
<h1>
Invalid Username or Password
</h1>
</c:otherwise>
</c:choose>
</body>
</html>-->

 <style>
        body {
            font-family: 'Arial', sans-serif;
           
            box-sizing: border-box;
        }

        .box-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .box {
            width: 200px;
            height: 150px;
            background-color: #3498db;
            margin: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 20px;
           border-radius: 15px;
            text-align: center;
            text-decoration: none;
        }
      
      .box1 {
            width: 200px;
            height: 150px;
            background-color: orange;
            margin: 10px;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            font-size: 20px;
           border-radius: 15px;
            text-align: center;
            text-decoration: none;
        }
      
      .box:hover {
            background-color: 		#66CDAA; /* Highlight color on hover */
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); 
             */
        }
      .box1:hover {
            background-color: #00CED1; /* Highlight color on hover */
                    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); 
             */
        }

        .box a {
            color: white;
            text-decoration: none;
        }
      .box1 a {
            color: white;
            text-decoration: none;
        }
    </style>
    
    
    <%@ include file="/HTML/DeptHallbooking/DeptHallHeader.html" %>
    <div class="main-content">
    <div class="box-container">
    <div class="box"><a href="../JSP/Dept/DeptSearchHall.jsp">Check Hall Availability</a></div>
    <div class="box"><a href="../DeptServlet/HallHistory">Hall History</a></div>
    </div>
    
    <div class="box-container">
    <div class="box1"><a href="../DeptServlet/BookingStatus">Hall booking Status</a></div>
    <div class="box1"><a href="../DeptServlet/DeleteRequest">Delete Request</a></div>
    </div>
    
    </div>
    
    
    
    <%@ include file="/HTML/DeptHallbooking/DeptHallFooter.html" %>