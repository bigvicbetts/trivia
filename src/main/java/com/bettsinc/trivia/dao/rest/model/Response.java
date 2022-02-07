package com.bettsinc.trivia.dao.rest.model;

import com.bettsinc.trivia.model.Question;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class Response {

    @JsonbProperty(value = "results")
    List<QuestionDao> questions;

    public Response(List<QuestionDao> questions) {
        this.questions = questions;
    }

    public Response() {
    }

    public List<QuestionDao> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDao> questions) {
        this.questions = questions;
    }
}
