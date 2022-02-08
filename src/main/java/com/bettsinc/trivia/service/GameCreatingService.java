package com.bettsinc.trivia.service;

import com.bettsinc.trivia.dao.QuestionRepository;
import com.bettsinc.trivia.dao.rest.model.QuestionDao;
import com.bettsinc.trivia.model.Game;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class GameCreatingService implements GameService {

    @Inject
    QuestionRepository questionRepository;

    @Override
    public Game createGame(int numberOfCategories) {
        Game game = new Game();
        List<Integer> categories = generateCategories(numberOfCategories);
        for (Integer category : categories) {
            List<QuestionDao> easy = questionRepository.getQuestions(2, category, "easy");
            List<QuestionDao> medium = questionRepository.getQuestions(2, category, "medium");
            List<QuestionDao> hard = questionRepository.getQuestions(2, category, "hard");
        }

        List<QuestionDao> easy = questionRepository.getQuestions(10, 9, "easy");
        return null;
    }

    private List<Integer> generateCategories(int numberOfCategories) {
        List<Integer> categories = new ArrayList<>();
        Random random = new Random();
        while (categories.size() < numberOfCategories) {
            int randomNumber = random.ints(9, 33).findFirst().getAsInt();
            if (!categories.contains(randomNumber)) {
                categories.add(randomNumber);
            } else {
                continue;
            }
        }

        return categories;
    }

}
