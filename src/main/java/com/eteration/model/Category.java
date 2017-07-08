package com.eteration.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by memojja on 04/07/2017.
 */
@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Question> questions;

    public Category(){}
    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Set<Question> questions) {
        this.name = name;
        this.questions = questions;
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

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
