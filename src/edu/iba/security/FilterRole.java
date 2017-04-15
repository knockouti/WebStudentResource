package edu.iba.security;

import edu.iba.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Igor on 10.04.2017.
 */

public class FilterRole implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        User user = (User) httpServletRequest.getSession().getAttribute("USER");
        String url = httpServletRequest.getRequestURI();
        if (user != null || url.endsWith(".js")
                || url.endsWith(".css")
                || url.endsWith(".html")
                || url.endsWith("/ServletLogin.jsp")
                || url.endsWith("loginpage.jsp")) {
            httpServletRequest.setAttribute("role", user);
            chain.doFilter(req, resp);
        } else {
            httpServletResponse.sendRedirect("loginpage.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
