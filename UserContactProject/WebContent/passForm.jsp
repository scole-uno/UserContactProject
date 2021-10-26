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
                        //Shows a message if the passwords didn't match.
                        if(session.getAttribute("noMatch") != null) {
                    %>
                            <p>The inputted passwords did not match.</p>
                    <%
                            session.setAttribute("noMatch", null);
                        }
                    %>
						<% 
		if(session.getAttribute("userName") == null) {
			response.sendRedirect("Login.jsp");
		}
		else {
			%>
			
			<table>
                            <form action="ChangePassword" method="POST">
                            <tr><td>New Password: </td>
                                <td><input type="password" name="newPassword" size="10"></td>
                            </tr>
                            <tr><td>Confirm New Password: </td>
                                <td><input type="password" name="confNewPassword" size="10"></td>
                            </tr>
                            <tr><td><input type="submit" value="Change"></td></tr>

                            </form>
                    </table>
                    <% 
		}
		%>

				</div>
			</div>
		</div>
	</body>
</html>