package org.example.ots.bean;

import com.opensymphony.xwork2.inject.Scope;
import com.opensymphony.xwork2.inject.Scoped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Scoped(Scope.SESSION)
public class ProgrammingLanguages {

    private static final List<String> allLanguages;
    static {
        allLanguages = new ArrayList<>();
        allLanguages.add("Java");
        allLanguages.add("JavaScript");
        allLanguages.add("Groovy");
        allLanguages.add("Scala");
        allLanguages.add("XText");
        allLanguages.add("Kotlin");
        allLanguages.add("Swift");
        allLanguages.add("Python");
        allLanguages.add("Clojure");
        allLanguages.add("Lisp");
        allLanguages.add("Go");
        allLanguages.add("Rust");
        allLanguages.add("C");
        allLanguages.add("C#");
        allLanguages.add("C++");
        allLanguages.add("R");
        allLanguages.add("PHP");
        allLanguages.add("Perl");
        allLanguages.add("Ruby");
        Collections.sort(allLanguages);
    }

    private List<String> notSelected = new ArrayList<>();
    private List<String> selected = new ArrayList<>();

    public ProgrammingLanguages() {
        notSelected.addAll(allLanguages);
    }

    public List<String> getNotSelected() {
        return notSelected;
    }

    public void setNotSelected(List<String> notSelected) {
        this.notSelected = notSelected;
    }

    public List<String> getSelected() {
        return selected;
    }

    public void setSelected(List<String> selected) {
        this.selected = selected;
    }
}
