package com.eteration.service;

import com.eteration.model.Comment;
import com.eteration.model.Question;
import com.eteration.model.dto.CommentDto;

/**
 * Created by memojja on 07/07/2017.
 */
public interface CommentService {

    public void save(Comment comment);
    public void delete(Long id);
    public void update(Comment comment);
    public void assignCommentWithQuestion(CommentDto commentDto, Question question);

}
