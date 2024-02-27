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
        out.println("<head><title>User Table</title>"
        		+ ""
        		+ ""
        		+ "<style>\r\n"
        		+ "        body {\r\n"
        		+ "            font-family: Arial, sans-serif;\r\n"
        		+ "            background-color: #f4f4f4;\r\n"
        		+ "            margin: 0;\r\n"
        		+ "            padding: 0;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        table {\r\n"
        		+ "            border-collapse: collapse;\r\n"
        		+ "            width: 80%;\r\n"
        		+ "            margin: 20px auto;\r\n"
        		+ "            background-color: #fff;\r\n"
        		+ "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        th, td {\r\n"
        		+ "            border: 1px solid #ddd;\r\n"
        		+ "            padding: 10px;\r\n"
        		+ "            text-align: left;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        th {\r\n"
        		+ "            background-color: #4CAF50;\r\n"
        		+ "            color: white;\r\n"
        		+ "        }\r\n"
        		+ "\r\n"
        		+ "        tr:nth-child(even) {\r\n"
        		+ "            background-color: #f2f2f2;\r\n"
        		+ "        }\r\n"
        		+ "    </style>"
        		+ "</head>");
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
