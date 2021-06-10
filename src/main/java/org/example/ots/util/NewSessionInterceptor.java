package org.example.ots.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class NewSessionInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        MyScopeFilter.newSessionOnNextRequest();
        return invocation.invoke();
    }

}
