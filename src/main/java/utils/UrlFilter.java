package utils;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet Filter implementation class UrlFilter
 */
@WebFilter("/*") // to filter the request , based on the current session
public class UrlFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public UrlFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Your logic to check the validity of the request
        boolean isValidRequest = isValid(httpRequest);

        if (!isValidRequest) {
            // Set the response status code to 404
            httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
           
            // Forward the request to the error page
            request.getRequestDispatcher("/errorPages/404.jsp").forward(request, response);
        } else {
            // Continue with the filter chain
            chain.doFilter(request, response);
        }
    }

	private boolean isValid(HttpServletRequest httpRequest) {
		String link = httpRequest.getRequestURI();
		switch(link)
		{
			case "/p2p_project/register.jsp":
				return true;
			case "/p2p_project/users.jsp":
				return true;
			case "/p2p_project/users":
				return true;
			case "/p2p_project/Users":
				return true;
			case "/p2p_project/hello":
				return true;
			case "/p2p_project/errorPages/*": 
				return true;
			default : 
				return false;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
