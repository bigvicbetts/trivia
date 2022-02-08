package com.bettsinc.trivia.mapping;

import com.bettsinc.trivia.dao.rest.model.QuestionDao;
import com.bettsinc.trivia.model.Question;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@ApplicationScoped
public class QuestionMapper implements Mapper<Question, QuestionDao> {

    @Override
    public Question map(QuestionDao source) {
        Map<String, Integer> pointValues = Map.of("easy", 100, "medium", 300, "hard", 500);
        Question question = new Question(
                source.getQuestion(),
                pointValues.get(source.getDifficulty()),
                populateChoices(source),
                populateAnswerMap(source));

        return question;
    }

    private Map<String, Boolean> populateAnswerMap(QuestionDao source) {
        return Map.of(
                source.getCorrectAnswer(), true,
                source.getIncorrectAnswers().get(0), false,
                source.getIncorrectAnswers().get(1), false,
                source.getIncorrectAnswers().get(2), false);
    }

    private List<String> populateChoices(QuestionDao source) {
        List<String> choices = source.getIncorrectAnswers();
        choices.add(source.getCorrectAnswer());
        return randomize(choices);

    }

    private List<String> randomize(List<String> choices) {
        Random random = new Random();
        List<String> randomizedChoices = new ArrayList<>();
        while (randomizedChoices.size() < choices.size()) {
            int randomNumber = random.ints(1, 5).findFirst().getAsInt();
            if (!randomizedChoices.contains(choices.get(randomNumber))) {
                randomizedChoices.add(choices.get(randomNumber));
            }
        }
        return randomizedChoices;
    }
}
