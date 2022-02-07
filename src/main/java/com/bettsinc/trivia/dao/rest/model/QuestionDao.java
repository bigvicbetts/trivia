package com.bettsinc.trivia.dao.rest.model;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class QuestionDao {

    private String category;
    private String difficulty;
    private String question;

    @JsonbProperty(value = "correct_answer")
    private String correctAnswer;

    @JsonbProperty(value = "incorrect_answers")
    private List<String> incorrectAnswers;

    public QuestionDao(String category, String difficulty, String question, String correctAnswer, List<String> incorrectAnswers) {
        this.category = category;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public QuestionDao() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
