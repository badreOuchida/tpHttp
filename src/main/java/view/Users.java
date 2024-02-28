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
        response.sendRedirect("users.jsp");
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		PrintWriter out = response.getWriter();
		dao = new UserDao();
		
        String nom = request.getParameter("nom");
        int res = dao.deleteUser(new User(nom));		
        //int gain = Integer.parseInt(request.getParameter(""));
		//boolean isBlackListed = Boolean.parseBoolean(request.getParameter("isBlackList"));
		out.print(res);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		dao = new UserDao();
		
        String nom = request.getParameter("nom");
        String gain = request.getParameter("gain");
        String isBlackListed = request.getParameter("blacklisted");
        System.out.println("nom : "+nom);
        System.out.println("gain : "+gain);
        System.out.println("isBlackListed : "+isBlackListed);
        int res = dao.updateUser(new User(nom,Integer.parseInt(gain),!Boolean.parseBoolean(isBlackListed)));		
		out.print(res);
		
	}
	
	
}
