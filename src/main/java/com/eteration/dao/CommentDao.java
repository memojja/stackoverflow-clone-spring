package com.eteration.dao;

import com.eteration.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by memojja on 07/07/2017.
 */
@Repository
public interface CommentDao extends CrudRepository<Comment,Long> {
}
