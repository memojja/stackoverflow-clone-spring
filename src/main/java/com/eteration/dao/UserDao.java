package com.eteration.dao;

import com.eteration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by memojja on 11/07/2017.
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
}
