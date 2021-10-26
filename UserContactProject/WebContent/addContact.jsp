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
						<li><a href = "searchContact.jsp">Search Contact</a></li>
						<li><a href = "passForm.jsp">Change Password</a></li>
						<li><a href = "LoggedOut.jsp">Logout</a></li>
					</ul>
				</div>
				
				<div id = "main">
				<%
					//Checks if a user is already in the session if so redirects.
						if (session.getAttribute("userName") == null) {
							response.sendRedirect("Login.jsp");
					}
					%>
					<%
						//Checks if all fields weren't filled.
						if (session.getAttribute("missingInfo") != null) {
							session.setAttribute("missingInfo", null);
					%>
							<p>Information is missing</p>
					<%
						}
					%>
					<%
						//Checks if the contact name was too long.
						if (session.getAttribute("contactLong") != null) {
							session.setAttribute("contactLong", null);
					%>
							<p>Contact name is too long.(25 characters max)</p>
					<%
						}
					%>
					<%
						//Checks if the phone number is too long.
						if (session.getAttribute("phoneLong") != null) {
							session.setAttribute("phoneLong", null);
					%>
							<p>Phone number is too long.(20 characters max)</p>
					<%
						}
					%>					
					<%
					//Checks if the address is too long.
						if (session.getAttribute("addressLong") != null) {
							session.setAttribute("addressLong", null);
					%>
							<p>Address is too long.(50 characters max)</p>
					<%
						}
					%>
					<%
						//Checks if the city name is too long.
						if (session.getAttribute("cityLong") != null) {
							session.setAttribute("cityLong", null);
					%>
							<p>City is too long.(20 characters max)</p>
					<%
						}
					%>
					<%
					//Checks if the state name is too long.
						if (session.getAttribute("stateLong") != null) {
							session.setAttribute("stateLong", null);
					%>
							<p>State is too long. (15 characters max)</p>
					<%
						}
					%>
					<%
					//Checks if the company name is too long.
						if (session.getAttribute("companyLong") != null) {
							session.setAttribute("companyLong", null);
					%>
							<p>Company is too long. (20 characters max)</p>
					<%
						}
					%>
					<%
						//Checks if the contact was added
						if (session.getAttribute("contactAdded") != null) {
							session.setAttribute("contactAdded", null);
					%>
							<p>Contact has been added.</p>
					<%
						}
					%>
			
			<table>
                            <form action="addContact" method="POST">
                            <tr><td>Name:</td>
                                <td><input type="text" name="contactName" size="10"></td>
                            </tr>
                            <tr><td>Phone Number:</td>
                                <td><input type="text" name="phoneNumber" size="10"></td>
                            </tr>
                            <tr><td>Address:</td>
                                <td><input type="text" name="address" size="10"></td>
                            </tr>
                            <tr><td>City:</td>
                                <td><input type="text" name="city" size="10"></td>
                            </tr>
                            <tr><td>State:</td>
                                <td><input type="text" name="state" size="10"></td>
                            </tr>
                            <tr><td>Company:</td>
                                <td><input type="text" name="company" size="10"></td>
                            </tr>
                            <tr><td><input type="submit" value="Submit"></td></tr>

                            </form>
                    </table>


				</div>
			</div>
		</div>
	</body>
</html>