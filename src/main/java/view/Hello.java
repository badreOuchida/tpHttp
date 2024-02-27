package view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import db.dao.user.IUser;
import db.dao.user.UserDao;
import db.models.User;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUser dao ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String docType =
		 "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		 "Transitional//EN\">\n";
		 String title = null;
		 String votreNom = null;
		 String nomPrenom = "Anonymous";
		 String gain = (String) request.getAttribute("gain");
		 votreNom = request.getParameter("nom");
		 System.out.println("nom = " + votreNom + " gain = " + gain);
		 if (votreNom != null && gain != null)
		 {
			 nomPrenom = votreNom.toUpperCase();
			 title = "<H1>Greetings " + nomPrenom + "!</H1>\n";
			 out.println(docType +
			 "<HTML>\n" +
			 "<HEAD><TITLE>Greetings Servlet</TITLE></HEAD>\n" +
			 "<BODY BGCOLOR=\"#FDF5E6\">\n" +
			 title +
			 "</BODY></HTML>");
			 // out.println("Vous avez gagne: "+ Math.random()* 10);
			 
			
			 out.println("Vous avez gagne: "+ gain);
			 out.println(" millions de dollars!");
		 }else {
			 out.println("Invalid request");
		 }
		 
		 
		 
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = null;
		String votreNom = null;
		String nomPrenom = "Anonymous";
		votreNom = request.getParameter("nom");
		if (votreNom != null)
		{
			nomPrenom = votreNom.toUpperCase();
			int gain = (int) (Math.random() * 10);
			dao = new UserDao();
			User user = dao.getUser(new User(votreNom,gain));
			if( (user != null && user.getRole().equals("tomcat")) || user == null )
			{
				dao.updateOrAddUser(new User(votreNom,gain));
				request.setAttribute("gain", String.valueOf(gain));
				doGet(request, response);
			}
			else {
				response.sendRedirect("register.html?status=403");
			}
		}else {
			response.sendRedirect("register.html?ststuc=400");
		}
		
			
	}

}
