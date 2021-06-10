package org.example.ots.action;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {

    @Override
    public String execute() {
        return SUCCESS;
    }

    public String returnSuccess() {
        return SUCCESS;
    }

}
