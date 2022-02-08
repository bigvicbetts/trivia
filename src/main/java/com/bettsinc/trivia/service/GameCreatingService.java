package com.bettsinc.trivia.service;

import com.bettsinc.trivia.dao.QuestionRepository;
import com.bettsinc.trivia.dao.rest.model.QuestionDao;
import com.bettsinc.trivia.mapping.Mapper;
import com.bettsinc.trivia.model.Category;
import com.bettsinc.trivia.model.Game;
import com.bettsinc.trivia.model.Question;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@ApplicationScoped
public class GameCreatingService implements GameService {

    @Inject
    QuestionRepository questionRepository;

    @Inject
    Mapper<Question, QuestionDao> questionMapper;

    @Override
    public Game createGame(int numberOfCategories) {
        List<Integer> categories = generateCategories(numberOfCategories);
        Game game = new Game();
        for (Integer category : categories) {
            List<QuestionDao> questions = questionRepository.getQuestions(2, category, "easy");
            List<QuestionDao> medium = questionRepository.getQuestions(2, category, "medium");
            List<QuestionDao> hard = questionRepository.getQuestions(2, category, "hard");
            questions.addAll(medium);
            questions.addAll(hard);
            Category category1 = new Category(questions.get(0).getCategory(), mapQuestions(questions));
            game.addCategory(category1);
        }
        return game;
    }

    private List<Question> mapQuestions(List<QuestionDao> questions) {
        return questions.stream().map(question -> questionMapper.map(question)).collect(Collectors.toList());
    }

    private List<Integer> generateCategories(int numberOfCategories) {
        List<Integer> categories = new ArrayList<>();
        Random random = new Random();
        while (categories.size() < numberOfCategories) {
            int randomNumber = random.ints(9, 33).findFirst().getAsInt();
            if (!categories.contains(randomNumber)) {
                categories.add(randomNumber);
            }
        }
        return categories;
    }

}
