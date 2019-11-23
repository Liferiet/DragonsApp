import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("loggedUser") != null);

        String loginURI = request.getContextPath() + "/login";

        boolean isLoginRequest = request.getRequestURI().equals(loginURI);

        boolean isLoginPage = request.getRequestURI().endsWith("login.jsp");

        if (isLoggedIn && (isLoginPage || isLoginRequest)) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/home");
            dispatcher.forward(servletRequest, servletResponse);
        } else if (isLoggedIn || isLoginRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("login.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
