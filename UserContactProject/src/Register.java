import util.DBConnection;

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


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Grabs variables from the session and assigns them.
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String fName = request.getParameter("fName");
		String lName = request.getParameter("lName");
		String age = request.getParameter("age");
		

		//Creates needed things for the DB.
		ResultSet rset = null;
		Connection connection = null;
		PreparedStatement ps = null;
		
		
		//Checks if something wasn't included in the registration.
		if (userName.equals("") || password.equals("") || fName.equals("") || lName.equals("") 
				|| age.equals("")) {
			session.setAttribute("missingInfo", "true");
			response.sendRedirect("Register.jsp");
		}
		//Checks if the username is too long.
		if (userName.length() > 20) {
			session.setAttribute("userLong", "true");
			response.sendRedirect("Register.jsp");
		}
		//Checks if the password is too long.
		if (password.length() > 20) {
			session.setAttribute("passLong", "true");
			response.sendRedirect("Register.jsp");
		}
		//Checks if the first name is too long.
		if (fName.length() > 20) {
			session.setAttribute("fNameLong", "true");
			response.sendRedirect("Register.jsp");
		}
		//Checks if the last name is too long.
		if (lName.length() > 20) {
			session.setAttribute("lNameLong", "true");
			response.sendRedirect("Register.jsp");
		}

		try {
			DBConnection.getDBConnection();
			connection = DBConnection.connection;
			ps = connection.prepareStatement("SELECT * FROM USERS WHERE username=? ");
			ps.setString(1, userName);
			rset = ps.executeQuery();
			
			//Checks if the username is taken.
			if(rset.next()) {
				session.setAttribute("NameTaken", "true");
				ps.close();
				response.sendRedirect("Register.jsp");
			}
			
			else {
				//Registers the user into the DB.
				ps = connection.prepareStatement("INSERT INTO USERS (id,username,password,fName,lName,age) values (default,?,?,?,?,?)");
				ps.setString(1, userName);
				ps.setString(2, password);
				ps.setString(3, fName);
				ps.setString(4, lName);
				ps.setString(5, age);
				ps.executeUpdate();
				
				//Assigns information to the session about who is logged in.
				session.setAttribute("userName", userName);
				session.setAttribute("password", password);
				session.setAttribute("fName", fName);
				session.setAttribute("lName", lName);
				session.setAttribute("age", age);
				
				response.sendRedirect("LoggedIn.jsp");
				
			}
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
