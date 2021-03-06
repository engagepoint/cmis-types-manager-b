package com.engagepoint.filter;
/**
 * User: stanislav.skrebtsov (stanislav.skrebtsov@engagepoint.com)
 * Date: 29.11.13
 * Time: 18:32
 */

import com.engagepoint.constant.NavigationConstants;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;

import static com.engagepoint.constant.FileConstants.XHTML;
import static com.engagepoint.constant.NameConstants.SESSION_DISPLAY_NAME;
import static com.engagepoint.constant.NavigationConstants.*;


public class LoginFilter implements Filter {
    public static final Deque<String> HISTORY = new LinkedList<String>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //because we don't need the implementation of this method
    }

    private void addRequestUrlToHistory(ServletRequest request) {
        String requestUrl = ((HttpServletRequest) request).getServletPath();
        requestUrl = requestUrl.substring(0, requestUrl.length() - XHTML.length());
        requestUrl += REDIRECT_TRUE;
        while (HISTORY.size() > 3) {
            HISTORY.removeFirst();
        }
        if (!HISTORY.contains(requestUrl)) {
            HISTORY.addLast(requestUrl);
        }

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        String sessionID = (session == null) ? null : (String) session.getAttribute(SESSION_DISPLAY_NAME);
        String contextPath = ((HttpServletRequest) request).getContextPath();
        if (StringUtils.isEmpty(sessionID)) {
            ((HttpServletResponse) response).sendRedirect(contextPath + NavigationConstants.LOGIN_PAGE);
        }
        addRequestUrlToHistory(request);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //because we don't need the implementation of this method
    }
}