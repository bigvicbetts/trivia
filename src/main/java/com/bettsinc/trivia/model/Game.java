package com.bettsinc.trivia.model;

import java.util.List;

public class Game {

    List<Category> categories;

    public Game(List<Category> categories) {
        this.categories = categories;
    }

    public Game() {
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }
}
