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
						//Redirects if you're already signed in.
						if (session.getAttribute("userName") != null) {
							response.sendRedirect("LoggedIn.jsp");
						}
					%>

					<%
						//Checks if you inputted correct credentials.
						if (session.getAttribute("failedAttempt") != null) {
							session.setAttribute("failedAttempt", null);
					%>
							<p>Invalid credentials.</p>
					<%
						}
					%>
						
					<table>
                            <form action="Login" method="POST">
                            <tr><td>Username: </td>
                                <td><input type="text" name="userName" size="10"></td>
                            </tr>
                            <tr><td>Password: </td>
                                <td><input type="password" name="password" size="10"></td>
                            </tr>
                            <tr><td><input type="submit" value="Login"></td></tr>

                            </form>
                    </table>
				</div>
			</div>
		</div>
	</body>
</html>