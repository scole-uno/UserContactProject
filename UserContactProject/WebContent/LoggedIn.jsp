<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css" type="text/css">
	<title>UserContactDB</title>
	
	</head>
	<body>
		<div id = "container">
			<div id = "header">
				<h1>User Contact DB</h1>	
			</div>
			
			<div id = "content">
				<div id = "nav">
					<ul class = "nav_links">
						<li><a href = "addContact.jsp">Create Contact</a></li>
						<li><a href = "searchContact.jsp">Search Contact</a></li>
						<li><a href = "passForm.jsp">Change Password</a></li>
						<li><a href = "LoggedOut.jsp">Logout</a></li>
					</ul>
				</div>
				
				<div id = "main">
					<p>Logged in as </p><%=session.getAttribute("userName") %>

				</div>
			</div>
		</div>
	</body>
</html>