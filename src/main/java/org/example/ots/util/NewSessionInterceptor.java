package org.example.ots.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewSessionInterceptor extends AbstractInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewSessionInterceptor.class);

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        try {
            ServletActionContext.getRequest().getSession().invalidate();
            LOGGER.debug("session invalidated");
        } catch (Exception ex) {
            LOGGER.error("could not invalidate the session", ex);
        }
        return invocation.invoke();
    }

}
