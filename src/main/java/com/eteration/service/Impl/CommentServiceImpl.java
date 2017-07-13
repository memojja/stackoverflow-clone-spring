package com.eteration.service.Impl;

import com.eteration.dao.CommentDao;
import com.eteration.model.Comment;
import com.eteration.model.Question;
import com.eteration.model.dto.CommentDto;
import com.eteration.service.CommentService;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by memojja on 07/07/2017.
 */
@Service
public class CommentServiceImpl implements CommentService{

    private final CommentDao commentDao;
    private final QuestionService questionService;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao, QuestionService questionService) {
        this.commentDao = commentDao;
        this.questionService = questionService;
    }

    @Override
    public void save(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentDao.delete(id);
    }

    @Override
    public void update(Comment comment) {
        commentDao.save(comment);
    }

    @Override
    public void assignCommentWithQuestion(CommentDto commentDto, Question questionDto) {

        Comment comment = new Comment();
        System.out.println("-=-------------------");

        System.out.println(commentDto);
        comment.setDescription(commentDto.getDescription());
        save(comment);

        Question question = questionService.findQuestionById(questionDto.getId());

        if(question.getComments() == null) {
            List<Comment> comments = new ArrayList<>();
            comments.add(comment);
            question.setComments(comments);
        }
        else {
            question.getComments().add(comment);
        }
        questionService.save(question);

    }
}
