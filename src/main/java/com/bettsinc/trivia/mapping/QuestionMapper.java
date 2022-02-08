package com.bettsinc.trivia.mapping;

import com.bettsinc.trivia.dao.rest.model.QuestionDao;
import com.bettsinc.trivia.model.Question;

import java.util.Map;

public class QuestionMapper implements Mapper<Question, QuestionDao> {

    @Override
    public Question map(QuestionDao source) {
        Map<String, Integer> pointValues = Map.of("easy", 100, "medium", 300, "hard", 500);
        return null;
    }
}
