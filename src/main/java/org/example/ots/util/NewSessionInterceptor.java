package org.example.ots.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class NewSessionInterceptor extends AbstractInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(NewSessionInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            ServletActionContext.getRequest().getSession().invalidate();
        } catch (Exception ex) {
            LOGGER.error("could not invalidate the session", ex);
        }
        return invocation.invoke();
    }

}
