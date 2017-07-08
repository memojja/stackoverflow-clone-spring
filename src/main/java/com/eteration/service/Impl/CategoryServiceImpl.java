package com.eteration.service.Impl;

import com.eteration.dao.CategoryDao;
import com.eteration.model.Category;
import com.eteration.model.Question;
import com.eteration.model.dto.QuestionDto;
import com.eteration.service.CategoryService;
import com.eteration.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by memojja on 07/07/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;
    private final QuestionService questionService;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao, QuestionService questionService) {
        this.categoryDao = categoryDao;
        this.questionService = questionService;
    }



    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryDao.findAll();
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public boolean existByName(String name) {
        if(categoryDao.countAllByName(name)==0)
            return false;
        else
            return true;
    }

    @Override
    public Category findByNAme(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public void assignCategoryWithQuestion(QuestionDto questionDto) {
        Question question = new Question();
        String[] categories = createQuestionFromQuestionDto(questionDto);
        assignQuestionWithCategory(questionDto, question, categories);

        questionService.save(question);
    }

    private void assignQuestionWithCategory(QuestionDto questionDto, Question question, String[] categories) {
        Arrays.stream(categories)
                .filter(a -> existByName(a))
                .forEach(
                        a->
                        {
                            Category category = findByNAme(a);
                            category.getQuestions().add(question);
                            if(question.getCategory() == null)
                                question.setCategory(new HashSet<Category>());
                            question.getCategory().add(category);

                        }
                );
        question.setDescription(questionDto.getDescription());
    }

    private String[] createQuestionFromQuestionDto(QuestionDto questionDto) {
        String[] categories = questionDto.getCategories().split(" ");
        Arrays.stream(categories)
                .filter(a -> !(existByName(a)))
                .forEach(a-> {
                    save(new Category(a,new HashSet<Question>()));
                });
        return categories;
    }

    public List<Category> getAllCategories(){
        return (List<Category>) categoryDao.findAll();
    }

}
