package com.bettsinc.trivia.dao;

import com.bettsinc.trivia.dao.rest.model.QuestionDao;

import java.util.List;

public interface QuestionRepository {

    List<QuestionDao> getQuestions(int amount, int category, String difficulty);
}
