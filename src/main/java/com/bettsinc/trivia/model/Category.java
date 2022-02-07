package com.bettsinc.trivia.model;

import java.util.List;

public class Category {

    private String name;
    private List<Question> questions;

    public Category(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
