package com.bettsinc.trivia.action;

import com.bettsinc.trivia.model.Game;
import com.bettsinc.trivia.service.GameService;
import com.opensymphony.xwork2.ActionSupport;

import javax.inject.Inject;

public class CreateGameAction extends ActionSupport {

    private int numberOfCategories;
    private int questionsPerCategory;

    @Inject
    GameService gameService;

    @Override
    public String execute() throws Exception {
        Game game = gameService.createGame(1);
         return SUCCESS;
    }

    public int getNumberOfCategories() {
        return numberOfCategories;
    }

    public void setNumberOfCategories(int numberOfCategories) {
        this.numberOfCategories = numberOfCategories;
    }

    public int getQuestionsPerCategory() {
        return questionsPerCategory;
    }

    public void setQuestionsPerCategory(int questionsPerCategory) {
        this.questionsPerCategory = questionsPerCategory;
    }
}
