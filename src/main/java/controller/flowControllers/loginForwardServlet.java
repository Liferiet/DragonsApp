package controller.flowControllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet//(value = "/loginServlet")
    public class loginForwardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter writer = resp.getWriter();
        writer.write("LoginServlet: mapping /login POST");*/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
/*        PrintWriter writer = resp.getWriter();
        writer.write("ControllerServlet: mapping /login GET");*/
    }
}
