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
						<li><a href = "LoggedIn.jsp">Home</a></li>
						<li><a href = "addContact.jsp">Create Contact</a></li>
						<li><a href = "passForm.jsp">Change Password</a></li>
						<li><a href = "LoggedOut.jsp">Logout</a></li>
					</ul>
				</div>
				
				<div id = "main">

		<% 
		//Redirects if you're not signed in.
		if(session.getAttribute("userName") == null) {
			response.sendRedirect("Login.jsp");
		}
		else {
			%>
			
			<table>
                            <form action="SearchContact" method="POST">
                            
                            <tr>
                                <td>Search By:</td>
                                <td><select name="criteria" id="criteria">
                                <option value="name">Name</option>
                                <option value="city">City</option>
                                <option value="state">State</option>
                                <option value="company">Company</option>
                            </select>
                                </td>
                            </tr><tr>
                                <td><input type="text" name="keyword" size="10"></td>
                            </tr>
                            <tr><td><input type="submit" value="Search"></td></tr>

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