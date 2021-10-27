

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBConnection;


/**
 * Servlet implementation class SearchContact
 */
@WebServlet("/SearchContact")
public class SearchContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//Sets up the HTML page.
		out.println("<!DOCTYPE html>\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; "
				+ "charset=UTF-8\">\n<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">\n<title>UserContactDB</title>"
				+ "\n</head>\n<body>\n<div id = \"container\">\n<div id = \"header\">\n<h1>User Contact DB</h1>	\n</div>"
				+ "\n<div id = \"content\">\n<div id = \"nav\">\n<ul class = \"nav_links\">"
				+ "\n<li><a href = \"LoggedIn.jsp\">Home</a></li>\n<li><a href = \"addContact.jsp\">Create Contact</a></li>"
				+ "\n<li><a href = \"passForm.jsp\">Change Password</a></li>\n<li><a href = \"LoggedOut.jsp\">Logout</a></li>"
				+ "\n</ul>\n</div>\n<div id = \"main\">");
		
		//Needed for the DB.
		ResultSet rset = null;
		Connection connection = null;
		PreparedStatement ps = null;
		
		String keyword = request.getParameter("keyword");
		String criteria = request.getParameter("criteria");
		
		
		try {
			DBConnection.getDBConnection();
			connection = DBConnection.connection;
			
			//Checks if no keyword is input, if none is found then returns everything.
			if (keyword.isEmpty()) {
				//Grabs all contacts with the user associated.
				ps = connection.prepareStatement("SELECT * FROM CONTACTS WHERE user=?;");
				ps.setString(1, (String) session.getAttribute("userName"));
			}
			else {
				//Finds rows that match criteria, keyword, and associated user.
				ps = connection.prepareStatement("SELECT * FROM CONTACTS WHERE user=? AND " + criteria + " LIKE ?;");
				ps.setString(1, (String) session.getAttribute("userName"));
				keyword = "%" + keyword + "%";
				ps.setString(2, keyword);

			}
			

			rset = ps.executeQuery();
			out.println("<ul>");
			while (rset.next()) {
				//Prints a contact.
				out.println("<li><p style=\"font-size:10px\">Name: " + rset.getString("name") + ",\tPhone: " + rset.getString("phone") + ",\tAddress: " + rset.getString("address")
				+ ",\tCity: " + rset.getString("city") + ",\tState: " + rset.getString("state") + ",\tCompany: " + rset.getString("company") + "</p></li>");
			}
			out.println("</ul>");
		}  catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
	         try {
	             if (ps != null)
	                ps.close();
	          } catch (SQLException se2) {
	          }
	          try {
	             if (connection != null)
	                connection.close();
	          } catch (SQLException se) {
	             se.printStackTrace();
	          }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
