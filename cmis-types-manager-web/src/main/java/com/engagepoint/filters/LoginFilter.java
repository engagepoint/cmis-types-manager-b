package com.engagepoint.filters; /**
 * User: stanislav.skrebtsov (stanislav.skrebtsov@engagepoint.com)
 * Date: 29.11.13
 * Time: 18:32
 */
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(filterName = "Filter", urlPatterns = {"*.xhtml"})
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpSession session = ((HttpServletRequest) request).getSession(false);
        String sessionID = (session == null) ? null : (String) session.getAttribute("sessionID");

        if (sessionID == null || sessionID.isEmpty()) {
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}