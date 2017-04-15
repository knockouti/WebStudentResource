package edu.iba.security;

import edu.iba.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       if(req instanceof HttpServletRequest) {
           HttpServletRequest httpServletRequest = (HttpServletRequest) req;
           HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
           User user = (User) httpServletRequest.getSession().getAttribute("USER");
           String url = httpServletRequest.getRequestURI();
           if (user != null
                   || url.endsWith(".js")
                   || url.endsWith(".css")
                   || url.endsWith(".html")
                   || url.endsWith("/ServletLogin")
                   || url.endsWith("loginpage.jsp")) {
               chain.doFilter(req, resp);
           } else {
               httpServletResponse.sendRedirect("loginpage.jsp");
           }
       }
       else {
           chain.doFilter(req,resp);
       }
    }


    public void init(FilterConfig config) throws ServletException {

    }

}
