import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//TODO fix this Filter
//@WebFilter("/app/*")
public class AuthenticationFilter implements Filter {

    public AuthenticationFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("in doFilter method");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession(false);

        System.out.println("current session" + session);
        if (session!=null) System.out.println(session.getAttribute("loggedUser"));

        boolean isLoggedIn = (session != null && session.getAttribute("loggedUser") != null);

        String loginURI = request.getContextPath() + "/app/login";

        boolean isLoginRequest = request.getRequestURI().equals(loginURI);

        boolean isLoginPage = request.getRequestURI().endsWith("login");

        System.out.println("requestUri = " + request.getRequestURI());

        if (isLoggedIn && (isLoginPage || isLoginRequest)) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/app/home");
            dispatcher.forward(servletRequest, servletResponse);
        } else if (isLoggedIn || isLoginRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("WEB-INF/app/login.jsp");
            dispatcher.forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
