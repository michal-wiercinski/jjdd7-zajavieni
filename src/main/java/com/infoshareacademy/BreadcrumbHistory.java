package com.infoshareacademy;

import java.util.LinkedList;

public class BreadcrumbHistory {

    private final LinkedList<String> history;


    public BreadcrumbHistory() {
        this.history = new LinkedList<String>();
    }

    public void addToHistory(String event) {
        history.push(event);
    }

    public void removeLast() {
        history.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String s : history) {
            sb.append(s).append(" >> ");
        }
        return sb.toString();
    }
}
