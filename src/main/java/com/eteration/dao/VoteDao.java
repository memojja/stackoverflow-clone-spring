package com.eteration.dao;

import com.eteration.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by memojja on 11/07/2017.
 */
@Repository
public interface VoteDao extends JpaRepository<Vote,Long> {
}
