package com.eteration;

import com.eteration.dao.CommentDao;
import com.eteration.dao.QuestionDao;
import com.eteration.model.Comment;
import com.eteration.model.Question;
import com.eteration.model.dto.CommentDto;
import com.eteration.model.dto.QuestionDto;
import com.eteration.service.CommentService;
import com.eteration.service.Impl.CommentServiceImpl;
import com.eteration.service.QuestionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;



import java.util.ArrayList;

/**
 * Created by memojja on 07/07/2017.
 */

public class CommentServiceTests {
/*
    private  CommentDao commentDaoMock;
    private QuestionService questionServiceMock;
    private CommentServiceImpl commentService;

    @Before
    public void setup(){
        commentDaoMock = Mockito.mock(CommentDao.class);
        questionServiceMock = Mockito.mock(QuestionService.class);
        commentService = new CommentServiceImpl(commentDaoMock,questionServiceMock);
    }

    @Test
    public void assignCommentWidthQuestions(){
        CommentDto commentDto = new CommentDto("aciklama");
        Question question = new Question();
        question.setId(1L);
        question.setComments(new ArrayList<Comment>());
        // Mockito.verify(commentService).assignCommentWithQuestion(commentDto,question);

    }
*/
}
