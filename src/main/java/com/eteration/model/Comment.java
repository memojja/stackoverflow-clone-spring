package com.eteration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by memojja on 04/07/2017.
 */
@Entity
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    //private List<Vote> votes;


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
}
