<!--
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome Admin</h1>

<h3>Admin Home Page</h3>-->



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


<%@ include file="/HTML/Header.html" %>

<div class="box-container">
    <div class="box"><a href="../JSP/Admin/AddDepartment.jsp">Add Department</a></div>
    <div class="box"><a href="../JSP/Admin/SearchDepartment.jsp">Search Department</a></div>
    <div class="box"><a href="../JSP/Admin/UpdateDepartment.jsp">Update Department</a></div>
    <div class="box"><a href="../JSP/Admin/DeleteDepartment.jsp">Delete Department</a></div>
</div>

<div class="box-container">
    <div class="box1"><a href="../JSP/Admin/Department/AddHall.jsp">Add Hall</a></div>
    <div class="box1"><a href="../JSP/Admin/Department/SearchHall.jsp">Search Hall</a></div>
    <div class="box1"><a href="../JSP/Admin/Department/UpdateHall.jsp">Update Hall</a></div>
    <div class="box1"><a href="../JSP/Admin/Department/DeleteHall.jsp">Delete Hall</a></div>
</div>

<div class="box-container">
    <div class="box"><a href="../AdminHallApproval/ApproveRequest">View Requests</a></div>
    <div class="box"><a href="../AdminHallApproval/BookingHistory">Booking History</a></div>
</div>

  
  

<!--  
<a href="../JSP/Admin/AddDepartment.jsp">Add Department</a>
<a href="../JSP/Admin/SearchDepartment.jsp">Search Department</a>
<a href="../JSP/Admin/UpdateDepartment.jsp">Update Department</a>
<a href="../JSP/Admin/DeleteDepartment.jsp">Delete Department</a>
<br>
<a href="../JSP/Admin/Department/AddHall.jsp">Add Hall</a>
<a href="../JSP/Admin/Department/SearchHall.jsp">Search Hall</a>
<a href="../JSP/Admin/Department/UpdateHall.jsp">Update Hall</a>
<a href="../JSP/Admin/Department/DeleteHall.jsp">Delete Department</a>
<br>
<a href="../AdminHallApproval/ApproveRequest">View Requests</a>
<a href="../AdminHallApproval/BookingHistory">Booking History</a>-->

<%@ include file="/HTML/Footer.html" %>
<!--  </body>
</html>-->