<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.ResultSet" %>  
<%@ include file="menu.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Registrations</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }

    .container {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 90%;
        max-width: 1200px;
        margin-top: 20px;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
        text-align: center;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    a {
        color: #5cb85c;
        text-decoration: none;
        font-weight: bold;
    }

    a:hover {
        color: #4cae4c;
    }
</style>
</head>
<body>


<div class="container">
    <h2>All Registrations</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Roll No</th>
            <th>Mobile No</th>
            <th>Branch</th>
            <th>Year</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <%
            ResultSet result = (ResultSet)request.getAttribute("res");
            while(result.next()){
        %>
        <tr>
            <td><%=result.getString(1)%></td>
            <td><%=result.getString(2)%></td>
            <td><%=result.getString(3)%></td>
            <td><%=result.getString(4)%></td>
            <td><%=result.getString(5)%></td>
            <td><a href="deleteInquiry?rollno=<%=result.getString(2)%>">Delete</a></td>
            <td><a href="updateInquiry?name=<%=result.getString(1)%>&branch=<%=result.getString(4)%>">Update</a></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
