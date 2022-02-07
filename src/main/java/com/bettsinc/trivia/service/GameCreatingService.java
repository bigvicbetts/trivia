package com.bettsinc.trivia.service;

import com.bettsinc.trivia.dao.QuestionRepository;
import com.bettsinc.trivia.dao.rest.model.QuestionDao;
import com.bettsinc.trivia.model.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GameCreatingService implements GameService {

    @Inject
    QuestionRepository questionRepository;

    @Override
    public Game createGame(int numberOfCategories, int questionsPerCategory) {

        List<QuestionDao> easy = questionRepository.getQuestions(10, 9, "easy");
        return null;
    }

}
