<%@ page import="java.io.*" %>
<%@ page import="db.dao.user.IUser" %>
<%@ page import="db.dao.user.UserDao" %>
<%@ page import="db.models.User" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%
    IUser dao = new UserDao();
    List<User> users = dao.getUsers();
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users table</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<table border='1'>
        <tr>
            <th>nom</th>
            <th>gain</th>
            <th>isBlackListed</th>
            <th>Actions</th>
        </tr>

        <%
    for (User user : users) {
        
			%>
			            <tr>
			                <td><%= user.getNom() %></td>
			                <td><%= user.getGain() %> M</td>
			                <td><%= user.isBlackList() %></td>
			                <td>
			                    <button style="padding: 10px 15px; background-color: red; color: white; border: none; border-radius: 5px; cursor: pointer;" onclick='deleteUser("<%= user.getNom() %>");'>Delete</button>
			                    <button style="padding: 10px 15px; background-color: #007BFF; color: white; border: none; border-radius: 5px; cursor: pointer;" onclick='putUser("<%= user.getNom() %>","<%= user.getGain() %>","<%= user.isBlackList() %>");'>Switch black list</button>
			                </td>
			            </tr>
			<%
			    }
			%>

</table>
<div style="text-align:center; padding:100px 0">
	<a href="register.jsp">register</a>
</div>
<script>
        function putUser(userName,gain,isBlackList) {
        	console.log("isBlackList : " +isBlackList);
        	const url = "http://localhost:8082/p2p_project/Users?nom="+userName+"&gain="+gain+"&blacklisted="+isBlackList;
            axios.put(url)
            .then(response => {
            	window.location.reload()
            })
            .catch(error => console.error('Error:', error));
        }
        
		function deleteUser(userName) {
		    console.log("Deleting user...");
		    const url = "http://localhost:8082/p2p_project/Users?nom="+userName;
		    axios.delete(url)
		        .then(response => {
		        	window.location.reload();
		        })
		        .catch(error => console.error('Error:', error));
		}
</script>

</body>
</html>