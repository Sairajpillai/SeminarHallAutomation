<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--  
<script>
        // JavaScript function to populate date options from the current date onwards
        function populateDates() {
            var today = new Date();
            var year = today.getFullYear();
            var month = today.getMonth() + 1; // Month is zero-based
            var day = today.getDate();

            var dateSelect = document.getElementById("datepicker");

            // Loop to populate dates for the next 30 days (adjust as needed)
            for (var i = 0; i < 30; i++) {
                var dateOption = new Date(year, month - 1, day + i);
                var dateString = dateOption.toISOString().split('T')[0];
                
                var option = document.createElement("option");
                option.value = dateString;
                option.text = dateString;
                dateSelect.add(option);
            }
        }
    </script>-->

</head>
 
<body>
<h1>Search Hall</h1>
<form action="../../DeptServlet/BookHall">
<label>Search Hall</label>
<input type="text" name="hallname">
 <label for="datepicker">Select Date:</label>
        <input type="date" id="datepicker" name="selectedDate" min="<%= java.time.LocalDate.now() %>">
<button type="submit">Book Hall</button>
</form>
</body>
<!--  
<body onload="populateDates()">

    <h2>Date Picker in JSP</h2>

    <form action="../../DeptServlet/BookHall" method="post">
        <label for="datepicker">Select Date:</label>

        
        <select id="datepicker" name="selectedDate"></select>

        <button type="submit">Submit</button>
    </form>

</body>
-->


</html>