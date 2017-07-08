package com.eteration.dao;

import com.eteration.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by memojja on 07/07/2017.
 */
@Repository
public interface CategoryDao extends CrudRepository<Category,Long> {
        Category findByName(String name);
/*
        @Query("SELECT t.title FROM Todo t where t.id = :id")
        String findTitleById(@Param("id") Long id);
*/

        int countAllByName(String name);
}

