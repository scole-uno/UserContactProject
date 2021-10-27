

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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		
		try {
			DBConnection.getDBConnection();
			connection = DBConnection.connection;
			
			
			
				//Makes sure the password is the one they wanted.
				if (request.getParameter("newPassword").equals(request.getParameter("confNewPassword"))) {
					//Replace the password from old to new.
					ps = connection.prepareStatement("UPDATE USERS SET password = ? WHERE username = ?");
					ps.setString(1, request.getParameter("newPassword"));
					ps.setString(2, (String) session.getAttribute("userName"));
					ps.executeUpdate();
					
					session.setAttribute("passChanged", "true");
					response.sendRedirect("LoggedIn.jsp");
				}
				else {
					session.setAttribute("noMatch", "true");
					response.sendRedirect("passForm.jsp");
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
