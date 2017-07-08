package com.eteration.controller;

import com.eteration.model.Category;
import com.eteration.model.Question;
import com.eteration.model.dto.CommentDto;
import com.eteration.model.dto.QuestionDto;
import com.eteration.service.CategoryService;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/questions",method = RequestMethod.POST)
    public String handleQuestionForm(@ModelAttribute QuestionDto questionDto){
        categoryService.assignCategoryWithQuestion(questionDto);
        return "redirect:/questions/";
    }

    @RequestMapping("/questions")
    public ModelAndView getQuestionList(Model model){
        return new ModelAndView("questionList","questions",questionService.getQuestionList());
    }

    @RequestMapping(value = "/questions/{id}")
    public String getQuestionById(@PathVariable("id")Long id,Model model){
        model.addAttribute("question",questionService.findQuestionById(id));
        model.addAttribute("comment",new CommentDto());
        return "question";
    }

    @RequestMapping(value = "/question/{id}",method = RequestMethod.DELETE)
    public String deleteQuestionById(@PathVariable("id")Long id){
        questionService.delete(id);
        return "redirect:/questions";
    }

    
}
