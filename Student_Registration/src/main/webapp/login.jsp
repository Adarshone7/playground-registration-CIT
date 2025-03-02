<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CIT Benagaluru play ground resgistration</title>
<style>
    /* Full-page background image */
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color :  #3973ac;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Centered container */
    .container {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        width: 500px;
        text-align: center;
    }

    /* Logo styling */
    .logo {
        width: 120px;
        margin-bottom: 10px;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    /* Form styling */
    .form-group {
        margin-bottom: 15px;
        text-align: left;
    }

    .form-group label {
        display: block;
        margin-bottom: 5px;
        color: #555;
    }

    .form-group input {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        transition: 0.3s;
    }

    /* Hover effect on input fields */
    .form-group input:hover, 
    .form-group input:focus {
        border-color: #5cb85c;
        box-shadow: 0 0 5px rgba(92, 184, 92, 0.5);
    }

    /* Submit button styling */
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 5px;
        background-color: #5cb85c;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    /* Hover effect on submit button */
    input[type="submit"]:hover {
        background-color: #4cae4c;
        transform: scale(1.05);
    }

    .error {
        color: #d9534f;
        margin-bottom: 15px;
    }
</style>
</head>
<body>

<!-- Logo above the form -->
<div class="container">
    <img src="https://gyaanarth.com/wp-content/uploads/2022/06/CI-TECH-LOGO-300x300.jpg" alt="Student Logo" class="logo">
    <h2>Login Here</h2>

    <% if(request.getAttribute("error") != null) { %>
        <p class='error'><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="verifyLogin" method="post">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" id="email" name="email" required/>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required/>
        </div>
        <input type="submit" value="Login"/>
    </form>
</div>

</body>
</html>
