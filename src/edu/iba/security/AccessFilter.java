package edu.iba.security;

import edu.iba.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        User user = (User) httpServletRequest.getSession().getAttribute("USER");
        String url = httpServletRequest.getRequestURI();
        if (user != null) {
            if (user.getRole() != null) {
                if (user.getRole().ordinal() >= getNecessaryRole(httpServletRequest).ordinal()) {
                    chain.doFilter(req, resp);
                } else {
                    httpServletResponse.sendRedirect("/AccessDenied.html");
                }
            } else {
                httpServletResponse.sendRedirect("/AccessDenied.html");
            }
        } else if (url.endsWith(".js")
                || url.endsWith(".css")
                || url.endsWith(".html")
                || url.endsWith("/ServletLogin")
                || url.endsWith("loginpage.jsp")) {
            chain.doFilter(req, resp);
        } else {
            httpServletResponse.sendRedirect("loginpage.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }


    private User.Role getNecessaryRole(HttpServletRequest request) {
        String url = request.getRequestURI();
        return url.contains("/form")
                ? url.contains("user") ? User.Role.ADMIN : request.getParameter("create") != null
                ? url.contains("mark") ? User.Role.PROFESSOR : User.Role.ADMIN
                : request.getParameter("update") != null ? User.Role.ADMIN : User.Role.STUDENT
                : User.Role.STUDENT;
    }

}
