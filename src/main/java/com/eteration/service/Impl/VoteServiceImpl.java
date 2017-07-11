package com.eteration.service.Impl;

import com.eteration.dao.VoteDao;
import com.eteration.model.Vote;
import com.eteration.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by memojja on 11/07/2017.
 */
@Service
public class VoteServiceImpl implements VoteService {

    private final VoteDao voteDao;

    @Autowired
    public VoteServiceImpl(VoteDao voteDao) {
        this.voteDao = voteDao;
    }

    @Override
    public void save(Vote vote) {

    }
}
