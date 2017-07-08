package com.eteration.service;

import com.eteration.model.Category;
import com.eteration.model.dto.QuestionDto;

import java.util.List;

/**
 * Created by memojja on 07/07/2017.
 */
public interface CategoryService {

    List<Category> getAll();
    void save(Category category);
    boolean existByName(String  name);
    Category findByNAme(String name);
    void assignCategoryWithQuestion(QuestionDto questionDto);
    List<Category> getAllCategories();


}
