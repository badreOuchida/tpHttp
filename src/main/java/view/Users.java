package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import db.dao.user.IUser;
import db.dao.user.UserDao;
import db.models.User;

/**
 * Servlet implementation class Users
 */
public class Users extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUser dao ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Users() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        dao = new UserDao();
        List<User> users = dao.getUsers();
        out.println("<html>");
        out.println("<head><title>User Table</title></head>");
        out.println("<body>");

        
        out.println("<table border='1'>");
        out.println("<tr><th>nom</th><th>gain</th></tr>");

        for(User user : users)
        {
        	out.println("<tr><td>"+user.getNom()+"</td><td>"+user.getGain()+" M</td></tr>");
        }
        

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
		
	}

}
