package org.example.ots.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.inject.Inject;
import org.example.ots.bean.ProgrammingLanguages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TransferAction extends ActionSupport {

    @Inject
    private ProgrammingLanguages languages;
    private List<String> selected = new ArrayList<>();
    private List<String> notSelected = new ArrayList<>();
    private String lastSelected;
    private int remaining;

    @Override
    public String execute() {
        copy(selected, languages.getSelected());
        copy(notSelected, languages.getNotSelected());
        initializeDerived();
        return SUCCESS;
    }

    public String save() {
        List<String> newlySelected = new ArrayList<>();
        copy(languages.getSelected(), selected);
        copy(languages.getNotSelected(), notSelected);
        initializeDerived();
        return SUCCESS;
    }

    private void copy(List<String> target, List<String> source) {
        target.clear();
        target.addAll(source);
    }

    private void initializeDerived() {
        if (selected.isEmpty()) {
            lastSelected = "none";
        } else {
            lastSelected = Arrays.toString(selected.toArray());
        }
        remaining = notSelected.size();
    }

    // --- Getters and Setters

    public List<String> getEmptyList() {
        return Collections.emptyList();
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }

    public List<String> getNotSelected() {
        return notSelected;
    }

    public void setNotSelected(List<String> notSelected) {
        this.notSelected = notSelected;
    }

    public String getLastSelected() {
        return lastSelected;
    }

    public void setLastSelected(String lastSelected) {
        this.lastSelected = lastSelected;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
