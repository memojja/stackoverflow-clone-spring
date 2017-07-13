package com.eteration.controller;

import com.eteration.model.Category;
import com.eteration.model.Question;
import com.eteration.model.dto.CommentDto;
import com.eteration.model.dto.QuestionDto;
import com.eteration.service.CategoryService;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by memojja on 07/07/2017.
 */
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final CategoryService categoryService;

    @Autowired
    public QuestionController(QuestionService questionService, CategoryService categoryService) {
        this.questionService = questionService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/questions/new",method = RequestMethod.GET)
    public ModelAndView getQuestionForm(){
        return new ModelAndView("createQuestion","question",new QuestionDto());
    }

    @RequestMapping(value = "/questions",method = RequestMethod.POST ,headers = "content-type=application/json")
    @ResponseBody
    public void handleQuestionForm(@Valid @RequestBody QuestionDto questionDto, BindingResult bindingResult){
        System.out.println(questionDto);
        if(!bindingResult.hasErrors())
        {
            System.out.println(categoryService);
            categoryService.assignCategoryWithQuestion(questionDto);
        }
    }


    @RequestMapping(value = "/questions/{id}")
    public @ResponseBody Question getQuestionById(@PathVariable("id") Long id){
        return questionService.findQuestionById(id);
    }
    @RequestMapping("/questions")
    public @ResponseBody List<Question> getQuestionList(Model model){
        return questionService.getQuestionList();
    }

    @ResponseBody
    @RequestMapping(value = "/questions/{id}",method = RequestMethod.DELETE)
    public void deleteQuestionById(@PathVariable("id")Long id){
        questionService.delete(id);
    }

    
}
