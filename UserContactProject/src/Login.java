

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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rset = null;
		
		try {
			DBConnection.getDBConnection();
			connection = DBConnection.connection;
			
			ps = connection.prepareStatement("SELECT * FROM USERS WHERE username=?");
			ps.setString(1, userName);
			
			rset = ps.executeQuery();
			if (rset.next()) {
				if (rset.getString("username").equals(userName) && rset.getString("password").equals(password)) {
					session.setAttribute("userName", userName);
					session.setAttribute("password", password);
					session.setAttribute("fName", rset.getString("fName"));
					session.setAttribute("lName", rset.getString("lName"));
					session.setAttribute("age", rset.getString("age"));
						
					response.sendRedirect("LoggedIn.jsp");
				}

			}
			else {
				session.setAttribute("failedAttempt", "true");
				response.sendRedirect("Login.jsp");
			}
			
			
			
		} catch (SQLException sx) {
			sx.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
