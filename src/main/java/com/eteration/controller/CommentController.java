package com.eteration.controller;

import com.eteration.model.Comment;
import com.eteration.model.Question;
import com.eteration.model.dto.CommentDto;
import com.eteration.service.CommentService;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by memojja on 07/07/2017.
 */
@Controller
public class CommentController {

    private final CommentService commentService;
    private final QuestionService questionService;

    @Autowired
    public CommentController(CommentService commentService, QuestionService questionService) {
        this.commentService = commentService;
        this.questionService = questionService;
    }



    @ResponseBody
    @RequestMapping(value = "/comments/{id}",method = RequestMethod.POST,headers = "content-type=application/json")
    public void handleComment( @RequestBody CommentDto comment,@PathVariable("id") Long id){

        commentService.assignCommentWithQuestion(comment,questionService.findQuestionById(id));

    }

    @RequestMapping(value = "/comments/{id}")
    public String deleteComment(@PathVariable("id")Long id){
        commentService.delete(id);
        return "redirect:/questions";
    }

}
