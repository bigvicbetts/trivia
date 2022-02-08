package com.bettsinc.trivia.model;

import java.util.List;
import java.util.Map;

public class Question {

    private String question;
    private Integer points;
    private List<String> possibleAnswers;
    private Map<String, Boolean> answerValidityMap;

    public Question(String question, Integer points, List<String> possibleAnswers, Map<String, Boolean> answerValidityMap) {
        this.question = question;
        this.points = points;
        this.possibleAnswers = possibleAnswers;
        this.answerValidityMap = answerValidityMap;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public Map<String, Boolean> getAnswerValidityMap() {
        return answerValidityMap;
    }

    public void setAnswerValidityMap(Map<String, Boolean> answerValidityMap) {
        this.answerValidityMap = answerValidityMap;
    }
}
