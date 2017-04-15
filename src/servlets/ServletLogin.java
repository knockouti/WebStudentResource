package servlets;

import edu.iba.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Igor on 04.04.2017.
 */
@WebServlet(name = "ServletLogin")

/**
 * Created by Igor on 04.04.2017.
 */

public class ServletLogin extends HttpServlet {

   // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String login  = request.getParameter("Login");
//        String password = request.getParameter("Password");
//        if(login.equals("Admin") && password.equals("1")){
//            request.getRequestDispatcher("sectionpage.jsp").forward(request,response);
//
//        }
//        else{
//            request.setAttribute("errorMessage", "Login or password is incorrect");
//            request.getRequestDispatcher("loginpage.jsp").forward(request,response);
//
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//    }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            User user = getUser(request.getParameter("Login"), request.getParameter("Password"));
            if (user != null) {
                request.getSession().setAttribute("USER", user);

                response.sendRedirect("sectionpage.jsp");
            } else {

                request.getSession().setAttribute("errorMessage", "Login or password is incorrect");
                response.sendRedirect("loginpage.jsp");

            }
        }
//private void installRole(User user,HttpServletRequest request,HttpServletResponse response) throws IOException {
//            if(user.getRole().toString().equals("STUDENT")){
//
//            }
//            else if(user.getRole().toString().equals("PROFESSOR")){
//
//            }
//            else if(user.getRole().toString().equals("ADMIN")){
//
//            }
//            else {
//                response.sendRedirect("loginpage.jsp");
//            }
//}
        private User getUser(String login, String password) {
            if (login.equals("admin") && password.equals("12345")) {
                User user = new User();
                user.setRole(User.Role.ADMIN);
                user.setPassword(password);
                user.setUser("admin");
                return user;
            } else if (login.equals("student") && password.equals("11111")) {
                User user = new User();
                user.setRole(User.Role.STUDENT);
                user.setPassword(password);
                user.setUser(login);
                return user;
            } else if (login.equals("professor") && password.equals("00000")) {
                User user = new User();
                user.setRole(User.Role.PROFESSOR);
                user.setPassword(password);
                user.setUser(login);
                return user;
            } else {
                return null;
            }
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }
    }


