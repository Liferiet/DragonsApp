package controller;

import bean.LoginBean;
import dao.LoginDao;
import model.Dragon;
import model.User;
import util.C3poDataSource;
import util.DataChecker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet( value = "/login")
public class LoginServlet extends HttpServlet {


    /**
     * This function is used only when in login.jsp to send login form for authorisation
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        DataChecker dataChecker = new DataChecker();
        boolean isEmailFormatOK = dataChecker.checkEmail(email);
        boolean isPasswordFormatOK = dataChecker.checkPassword(password);

        if (!isEmailFormatOK || !isPasswordFormatOK) {
            req.setAttribute("errLoginFormat", "Email or password has wrong format");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);

        LoginDao loginDao = new LoginDao();
        boolean userValidate = loginDao.authenticateUser(loginBean);

        if (userValidate) {
            HttpSession session = req.getSession();
            User user = new User();
            user.setEmail(email);

/*            List<Dragon> dragonList = new ArrayList<>();
            Dragon d = null;
            for (int i = 0; i < 10; i++) {
                d = new Dragon();
                d.setName("Fiona" + i);
                d.setStrength(i);
                d.setAgility(i);
                d.setIntelligence(i);
                d.setVitality(i);
                d.setLuck(i);
                dragonList.add(d);
            }
            user.setDragonList(dragonList);*/

            session.setAttribute("user", user);
            resp.sendRedirect("home.jsp");
        } else {
            req.setAttribute("errMessage", "false");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


}
