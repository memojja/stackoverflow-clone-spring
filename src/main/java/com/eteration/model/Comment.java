package com.eteration.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by memojja on 04/07/2017.
 */
@Entity
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @OneToOne(cascade = {CascadeType.ALL})
    private Vote vote;

    public Comment(){}
    public Comment(String description, Vote vote) {
        this.description = description;
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }


}
