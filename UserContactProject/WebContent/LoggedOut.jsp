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
						<li><a href = "index.html">Home</a></li>
					</ul>
				</div>
				
				<div id = "main">
					<%
						session.setAttribute("userName", null);
						session.setAttribute("password", null);
						session.setAttribute("fName", null);
						session.setAttribute("lName", null);
						session.setAttribute("age", null);
					
					%>
					<p>You are now logged out.</p>

				</div>
			</div>
		</div>
	</body>
</html>