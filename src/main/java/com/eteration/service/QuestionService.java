package com.eteration.service;

import com.eteration.model.Question;

import java.util.List;

/**
 * Created by memojja on 07/07/2017.
 */
public interface QuestionService {

    public Question findQuestionById(Long id);
    public void save(Question question);
    public List<Question> getQuestionList();
    public void delete(Long id);
}
