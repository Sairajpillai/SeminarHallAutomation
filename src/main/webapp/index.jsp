<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Landing Page</h1>
<form action="./AdminServlet/home" method="get">
<button type="submit">Submit</button>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      margin: 0;
      padding: 0;
      display: flex;
      height: 100vh;
    }

    .left-side, .right-side {
      flex: 1;
      height: 100%;
    }

    form {
      padding: 20px;
      margin: 20px;
      background-color: #f0f0f0;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
  </style>
  <title>Welcome Page</title>
</head>
<body>
  <div class="left-side">
    <form action="./AdminServlet/home" method="post">
      <!-- Your left side form content goes here -->
      <h2>Admin Login</h2>
      <label for="leftInput">Login Id:</label>
      <input type="text" id="leftInput" name="loginid">
      <label for="rightinput">Password:</label>
      <input type="password" id="leftInput" name="loginpassword">
      <!-- Add more form fields as needed -->
      <button type="submit">Admin Login</button>
    </form>
  </div>

  <div class="right-side">
    <form action="./DeptServlet/home" method="post">
      <!-- Your right side form content goes here -->
      <h2>Department Login</h2>
      <label for="leftInput">Login Id:</label>
      <input type="text" id="leftInput" name="loginid">
      <label for="rightinput">Password:</label>
      <input type="password" id="leftInput" name="loginpassword">
      <!-- Add more form fields as needed -->
      <button type="submit">Admin Login</button>
    </form>
  </div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      margin: 0;
      padding: 0;
      display: flex;
      height: 100vh;
      justify-content: center;
      align-items: center;
    }

    .split-container {
      display: flex;
      width: 80%;
      height: 60%;
    }

    .left-side, .right-side {
      flex: 1;
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }

    form {
      width: 80%;
      padding: 20px;
      margin: 20px;
      background-color: #f0f0f0;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      text-align: center; /* Center text within the form */
    }

    .form-group {
      margin-bottom: 15px;
    }

    button {
      width: 50%; /* Set a width to center the button */
      padding: 10px;
      background-color: #4caf50;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
  </style>
  <title>Centered Split Forms</title>
</head>
<body>
  <div class="split-container">
    <div class="left-side">
      <form action="./AdminServlet/home" method="post">
        <!-- Your left side form content goes here -->
        <h2>Admin Login</h2>
        <div class="form-group">
          <label for="leftInput">Login Id:</label>
      <input type="text" id="leftInput" name="loginid">
        </div>
        <div class="form-group">
           <label for="rightinput">Password:</label>
      <input type="password" id="leftInput" name="loginpassword">
        </div>
        <!-- Add more form fields as needed -->
       <button type="submit">Admin Login</button>
      </form>
    </div>

    <div class="right-side">
      <form action="./DeptServlet/home" method="post">
        <!-- Your right side form content goes here -->
        <h2>Right Side Form</h2>
        <div class="form-group">
           <label for="leftInput">Login Id:</label>
      <input type="text" id="leftInput" name="loginid">
        </div>
        <div class="form-group">
          <label for="rightinput">Password:</label>
      <input type="password" id="leftInput" name="loginpassword">
        </div>
        <!-- Add more form fields as needed -->
        <button type="submit">Dept Login</button>
      </form>
    </div>
  </div>
</body>
</html>--%>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      margin: 0;
      padding: 0;
      display: flex;
      height: 100vh;
      justify-content: center;
      align-items: center;
      background-color: black;
      color: white;
    }

    .split-container {
      display: flex;
      width: 80%;
      height: 60%;
    }

    .left-side, .right-side {
      flex: 1;
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      background-color: #333;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      margin: 10px;
    }

    form {
      width: 80%;
      padding: 20px;
      text-align: center;
    }

    .form-group {
      margin-bottom: 15px;
    }

    input[type="text"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px; /* Set border-radius to 5px for input fields */
      box-sizing: border-box;
    }
    
    input[type="password"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px; /* Set border-radius to 5px for input fields */
      box-sizing: border-box;
    }

    button {
      width: 50%;
      padding: 10px;
      background-color: #0000FF;
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }
  </style>
  <title>Centered Split Forms</title>
</head>
<body>
  <div class="split-container">
    <div class="left-side">
      <form action="./AdminServlet/home" method="post">
        <!-- Your left side form content goes here -->
        <h2>Admin Login</h2>
        <div class="form-group">
          <label for="leftInput">Login Id:</label>
      <input type="text" id="leftInput" name="loginid">
        </div>
        <div class="form-group">
           <label for="rightinput">Password:</label>
      <input type="password" id="leftInput" name="loginpassword">
        </div>
        <!-- Add more form fields as needed -->
       <button type="submit">Admin Login</button>
      </form>
    </div>

    <div class="right-side">
       <form action="./DeptServlet/home" method="post">
        <!-- Your right side form content goes here -->
        <h2>Dept Login</h2>
        <div class="form-group">
           <label for="leftInput">Login Id:</label>
      <input type="text" id="leftInput" name="loginid">
        </div>
        <div class="form-group">
          <label for="rightinput">Password:</label>
      <input type="password" id="leftInput" name="loginpassword">
        </div>
        <!-- Add more form fields as needed -->
        <button type="submit">Dept Login</button>
      </form>
    </div>
  </div>
</body>
</html>


