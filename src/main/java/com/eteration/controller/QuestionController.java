package com.eteration.controller;

import com.eteration.model.Question;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by memojja on 07/07/2017.
 */
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    /*
    @RequestMapping(value = "/questions/{id}" ,method = RequestMethod.GET)
    public @ResponseBody Question listQuestions(@PathVariable("id") Long id) {
        return questionService.findQuestionById(id);
    }
    */

    @RequestMapping(value = "/questions/new",method = RequestMethod.GET)
    public ModelAndView getQuestionForm(){
        return new ModelAndView("createQuestion","question",new Question());
    }

    @RequestMapping(value = "/questions",method = RequestMethod.POST)
    public String handleQuestionForm(@ModelAttribute Question question){
        questionService.save(question);
        return "redirect:/questions/" + question.getId();
    }

    @RequestMapping("/questions")
    public ModelAndView getQuestionList(){
        return new ModelAndView("questionList","questions",questionService.getQuestionList());
    }

    @RequestMapping(value = "/questions/{id}")
    public ModelAndView getQuestionById(@PathVariable("id")Long id){
        return new ModelAndView("question","question",questionService.findQuestionById(id));
    }

    @RequestMapping(value = "/question/{id}",method = RequestMethod.DELETE)
    public String deleteQuestionById(@PathVariable("id")Long id){
        questionService.deleteQuestionById(id);
        return "redirect:/questions";
    }

    
}
