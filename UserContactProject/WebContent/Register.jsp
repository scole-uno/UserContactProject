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
						<li><a href = "Login.html">Login</a></li>
					</ul>
				</div>
				
				<div id = "main">
					<%
					//Checks if a user is already in the session if so redirects.
						if (session.getAttribute("userName") != null) {
							response.sendRedirect("LoggedIn.jsp");
					}
					%>
					<%
						if (session.getAttribute("missingInfo") != null) {
							session.setAttribute("missingInfo", null);
					%>
							<p>Information is missing</p>
					<%
						}
					%>
					<%
						if (session.getAttribute("userLong") != null) {
							session.setAttribute("userLong", null);
					%>
							<p>Username is too long.(20 characters max)</p>
					<%
						}
					%>
					<%
						if (session.getAttribute("passLong") != null) {
							session.setAttribute("passLong", null);
					%>
							<p>Password is too long.(20 characters max)</p>
					<%
						}
					%>					
					<%
						if (session.getAttribute("fNameLong") != null) {
							session.setAttribute("fNameLong", null);
					%>
							<p>Password is too long.(20 characters max)</p>
					<%
						}
					%>
					<%
						if (session.getAttribute("lNameLong") != null) {
							session.setAttribute("lNameLong", null);
					%>
							<p>Password is too long.(20 characters max)</p>
					<%
						}
					%>
					<%
						if (session.getAttribute("NameTaken") != null) {
							session.setAttribute("NameTaken", null);
					%>
							<p>Username is already in use.</p>
					<%
						}
					%>
						
					<table>
                            <form action="Register" method="POST">
                            <tr><td>Username: </td>
                                <td><input type="text" name="userName" size="10"></td>
                            </tr>
                            <tr><td>Password: </td>
                                <td><input type="password" name="password" size="10"></td>
                            </tr>
                            <tr><td>First Name: </td>
                                <td><input type="text" name="fName" size="10"></td>
                            </tr>
                            <tr><td>Last Name: </td>
                                <td><input type="text" name="lName" size="10"></td>
                            </tr>
                            <tr>
                                <td>Age:</td>
                                <td><select name="age" id="age">
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                <option value="17">17</option>
                                <option value="18">18</option>
                                <option value="19">19</option>
                                <option value="20">20</option>
                                <option value="21">21</option>
                                <option value="22">22</option>
                                <option value="23">23</option>
                                <option value="24">24</option>
                                <option value="25">25</option>
                                <option value="26">26</option>
                                <option value="27">27</option>
                                <option value="28">28</option>
                                <option value="29">29</option>
                                <option value="30">30</option>
                                <option value="31">31</option>
                                <option value="32">32</option>
                                <option value="33">33</option>
                                <option value="34">34</option>
                                <option value="35">35</option>
                                <option value="36">36</option>
                                <option value="37">37</option>
                                <option value="38">38</option>
                                <option value="39">39</option>
                                <option value="40">40</option>
                                <option value="41">41</option>
                                <option value="42">42</option>
                                <option value="43">43</option>
                                <option value="44">44</option>
                                <option value="45">45</option>
                                <option value="46">46</option>
                                <option value="47">47</option>
                                <option value="48">48</option>
                                <option value="49">49</option>
                                <option value="50">50</option>
                                <option value="51">51</option>
                                <option value="52">52</option>
                                <option value="53">53</option>
                                <option value="54">54</option>
                                <option value="55">55</option>
                                <option value="56">56</option>
                                <option value="57">57</option>
                                <option value="58">58</option>
                                <option value="59">59</option>
                                <option value="60">60</option>
                                <option value="61">61</option>
                                <option value="62">62</option>
                                <option value="63">63</option>
                                <option value="64">64</option>
                                <option value="65">65</option>
                                <option value="66">66</option>
                                <option value="67">67</option>
                                <option value="68">68</option>
                                <option value="69">69</option>
                                <option value="70">70</option>
                            </select>
                                </td>
                            </tr>
                            <tr><td><input type="submit" value="submit"></td></tr>

                            </form>
                    </table>
				</div>
			</div>
		</div>
	</body>
</html>