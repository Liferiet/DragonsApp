package controller;

import bean.SignUpBean;
import dao.SignUpDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//TODO comments
@WebServlet(value = "/signUp")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");

        SignUpBean bean = new SignUpBean();
        bean.setEmail(email);
        bean.setPassword(password);
        bean.setNickname(nickname);

        SignUpDao dao = new SignUpDao();

        boolean accExists = dao.createAccount(bean);

        if (accExists) {
            req.setAttribute("errMessage", "email is already used");
            System.out.println("konto istnieje");
            //req.getRequestDispatcher("signup.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login.jsp");
            System.out.println("konto NIE istnieje, wiec je zalozylismy");
        }



    }
}
