package com.eteration.model.dto;

/**
 * Created by memojja on 07/07/2017.
 */
public class QuestionDto {

    private String title;
    private  String description;
    private String categories;

    public String getDescription() {
        return description;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
