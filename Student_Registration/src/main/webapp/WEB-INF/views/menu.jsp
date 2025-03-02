<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
        width: 300px;
    }

    h1 {
        margin-bottom: 20px;
        color: #333;
    }

    .menu {
        margin-bottom: 20px;
    }

    .menu a {
        display: block;
        margin: 10px 0;
        padding: 10px;
        background-color: #5cb85c;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .menu a:hover {
        background-color: #4cae4c;
    }

    .logout-button {
        margin-top: 20px;
    }

    .logout-button input[type="submit"] {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 5px;
        background-color: #d9534f;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .logout-button input[type="submit"]:hover {
        background-color: #c9302c;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Menu</h1>
    <div class="menu">
        <a href="addInquiryController">Add Inquiry</a>
        <a href="listInquiriesController">View Inquiries</a>
    </div>
    <div class="logout-button">
        <form action="logOut" method="post">
            <input type="submit" value="Log Out"/>
        </form>
    </div>
</div>
</body>
</html>
