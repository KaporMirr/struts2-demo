package org.example.ots.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyScopeFilter implements Filter {

    private static final ThreadLocal<MyScopeFilter> SCOPE_FILTER_THREAD_LOCAL = new InheritableThreadLocal<>();
    private boolean newSession;

    public static void newSessionOnNextRequest() {
        MyScopeFilter myScopeFilter = SCOPE_FILTER_THREAD_LOCAL.get();
        if (myScopeFilter != null) {
            myScopeFilter.newSession = true;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SCOPE_FILTER_THREAD_LOCAL.set(this);
        MyScopeStrategy.setCurrentRequest(servletRequest);
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            invalidateSessionWhenRequested(httpRequest);
            MyScopeStrategy.setCurrentSession(httpRequest.getSession(true));
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            SCOPE_FILTER_THREAD_LOCAL.set(null);
        }
    }

    private void invalidateSessionWhenRequested(HttpServletRequest httpRequest) {
        if (newSession) {
            httpRequest.getSession().invalidate();
            newSession = false;
        }
    }
}
