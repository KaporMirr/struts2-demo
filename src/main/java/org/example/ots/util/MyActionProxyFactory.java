package org.example.ots.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.DefaultActionProxyFactory;

public class MyActionProxyFactory extends DefaultActionProxyFactory {

    @Override
    public ActionProxy createActionProxy(ActionInvocation inv, String namespace, String actionName, String methodName, boolean executeResult, boolean cleanupContext) {
        MyActionProxy myProxy = new MyActionProxy(inv, namespace, actionName, methodName, executeResult, cleanupContext);
        container.inject(myProxy);
        container.setScopeStrategy(MyScopeStrategy.getInstance());
        myProxy.prepare();
        return myProxy;
    }
}
