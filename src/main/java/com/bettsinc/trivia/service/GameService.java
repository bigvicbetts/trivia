package com.bettsinc.trivia.service;

import com.bettsinc.trivia.model.Game;

public interface GameService {

    Game createGame(int numberOfCategories, int questionsPerCategory);

}
