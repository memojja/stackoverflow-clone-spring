package com.eteration.model;

import java.util.List;

/**
 * Created by memojja on 04/07/2017.
 */
public class Category {

    private Long id;
    private  String name;
    private List<Question> questions;

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
