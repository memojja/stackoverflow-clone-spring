package com.eteration.model;

/**
 * Created by memojja on 04/07/2017.
 */
public class Question {

    private String title;
    private String description;
    private String categories;

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Question(String title, String description, String categories) {
        this.title = title;
        this.description = description;
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
}
