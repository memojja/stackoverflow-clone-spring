package com.eteration.service.Impl;

import com.eteration.dao.QuestionDao;
import com.eteration.model.Question;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by memojja on 07/07/2017.
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    @Autowired
    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public Question findQuestionById(Long id) {
        return questionDao.findOne(id);
    }

    @Override
    public void save(Question question) {
        question.setCreatedDate(new Date());
        questionDao.save(question);
    }

    @Override
    public List<Question> getQuestionList() {

        return (List<Question>) questionDao.findAll();
    }

    @Override
    public void delete(Long id) {
        questionDao.delete(id);
    }
}
