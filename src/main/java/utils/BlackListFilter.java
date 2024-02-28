package utils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import db.dao.user.IUser;
import db.dao.user.UserDao;
import db.models.User;

/**
 * Servlet Filter implementation class BlackListFilter
 */
public class BlackListFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public BlackListFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String nom = request.getParameter("nom");
        System.out.println("User Name in Filter: " + nom);
        
        IUser dao = new UserDao();
        
        User user = dao.getUser(new User(nom));
        
        if( (user != null && !user.isBlackList()) || user == null )
        {
    		chain.doFilter(request, response);

        }else {
        	HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    	    httpServletResponse.sendRedirect("/p2p_project/register.jsp?status=403");
        }
        
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
