package org.example.ots.util;

import com.opensymphony.xwork2.inject.Scope;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.Callable;

public class MyScopeStrategy implements Scope.Strategy {

    private interface WithAttributes {
        <T> T getAttribute(String name);
        void setAttribute(String name, Object value);
    }

    private static final MyScopeStrategy INSTANCE = new MyScopeStrategy();

    public static Scope.Strategy getInstance() {
        return INSTANCE;
    }

    @Override
    public <T> T findInRequest(Class<T> type, String name, Callable<? extends T> factory) throws Exception {
        return findAttribute(type, name, factory, asWithAttributes(ServletActionContext.getRequest()));
    }

    @Override
    public <T> T findInSession(Class<T> type, String name, Callable<? extends T> factory) throws Exception {
        return findAttribute(type, name, factory, asWithAttributes(ServletActionContext.getRequest().getSession()));
    }

    private WithAttributes asWithAttributes(HttpServletRequest request) {
        return new WithAttributes() {
            @Override
            @SuppressWarnings("unchecked")
            public <T> T getAttribute(String name) {
                return (T) request.getAttribute(name);
            }
            @Override
            public void setAttribute(String name, Object value) {
                request.setAttribute(name, value);
            }
        };
    }

    private WithAttributes asWithAttributes(HttpSession session) {
        return new WithAttributes() {
            @Override
            @SuppressWarnings("unchecked")
            public <T> T getAttribute(String name) {
                return (T) session.getAttribute(name);
            }
            @Override
            public void setAttribute(String name, Object value) {
                session.setAttribute(name, value);
            }
        };
    }

    private <T> T findAttribute(Class<T> type,
                                String name,
                                Callable<? extends T> factory,
                                WithAttributes withAttributes) throws Exception {
        if (withAttributes != null) {
            String attributeName = getAttributeName(type, name);
            // need to synchronize on Session or Request
            // noinspection SynchronizationOnLocalVariableOrMethodParameter
            synchronized (withAttributes) {
                T value = withAttributes.getAttribute(attributeName);
                if (value == null) {
                    value = factory.call();
                    withAttributes.setAttribute(attributeName, value);
                }
                return value;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public <T> T findInWizard(Class<T> type, String name, Callable<? extends T> factory) {
        throw new UnsupportedOperationException();
    }

    private <T> String getAttributeName(Class<T> type, String name) {
        return type.getName() + "@" + name;
    }
}
