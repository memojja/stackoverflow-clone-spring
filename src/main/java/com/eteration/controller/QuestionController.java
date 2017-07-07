package com.eteration.controller;

import com.eteration.model.Question;
import com.eteration.model.dto.CommentDto;
import com.eteration.model.dto.QuestionDto;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return new ModelAndView("createQuestion","question",new QuestionDto());
    }

    @RequestMapping(value = "/questions",method = RequestMethod.POST)
    public String handleQuestionForm(@ModelAttribute QuestionDto question){
        Question question1 = new Question();
        question1.setDescription(question.getDescription());
        questionService.save(question1);
        return "redirect:/questions/" + question1.getId();
    }

    @RequestMapping("/questions")
    public ModelAndView getQuestionList(){
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
