

import java.io.IOException;
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
 * Servlet implementation class addContact
 */
@WebServlet("/addContact")
public class addContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Grabs variables from the session and assigns them.
		String contactName = request.getParameter("contactName");
		String phone = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String company = request.getParameter("company");

		//Creates needed things for the DB.
		ResultSet rset = null;
		Connection connection = null;
		PreparedStatement ps = null;
		
		
		//Checks if something wasn't included in the registration.
		if (contactName.isEmpty() || phone.isEmpty() || address.isEmpty() || city.isEmpty()
				|| state.isEmpty() || company.isEmpty()) {
			session.setAttribute("missingInfo", "true");
			response.sendRedirect("addContact.jsp");
		}
		//Checks if the username is too long.
		else if (contactName.length() > 25) {
			session.setAttribute("contactLong", "true");
			response.sendRedirect("addContact.jsp");
		}
		//Checks if the password is too long.
		else if (phone.length() > 20) {
			session.setAttribute("phoneLong", "true");
			response.sendRedirect("addContact.jsp");
		}
		//Checks if the first name is too long.
		else if (address.length() > 50) {
			session.setAttribute("addressLong", "true");
			response.sendRedirect("addContact.jsp");
		}
		//Checks if the last name is too long.
		else if (city.length() > 20) {
			session.setAttribute("cityLong", "true");
			response.sendRedirect("addContact.jsp");
		}
		//Checks if the last name is too long.
		else if (state.length() > 15) {
			session.setAttribute("stateLong", "true");
			response.sendRedirect("addContact.jsp");
		}
		//Checks if the last name is too long.
		else if (company.length() > 20) {
			session.setAttribute("companyLong", "true");
			response.sendRedirect("addContact.jsp");
		}
		else {
			try {
			
			DBConnection.getDBConnection();
			connection = DBConnection.connection;

			

				//Registers the user into the DB.
				ps = connection.prepareStatement("INSERT INTO CONTACTS (id,user,name,phone,address,city,state,company) "
						+ "values (default,?,?,?,?,?,?,?)");
				ps.setString(1, (String) session.getAttribute("userName"));
				ps.setString(2, contactName);
				ps.setString(3, phone);
				ps.setString(4, address);
				ps.setString(5, city);
				ps.setString(6, state);
				ps.setString(7, company);
				ps.executeUpdate();
				
				
				
				session.setAttribute("contactAdded", "true");

				
				response.sendRedirect("addContact.jsp");
				
			
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
