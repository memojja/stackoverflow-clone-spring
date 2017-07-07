package com.eteration.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by memojja on 04/07/2017.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private Date cratedDate;
    //private User user;
    //private Category category;
    //private List<Vote> votes;
    @OneToMany
    private List<Comment> comments;


    public Question(){
    }
    public Question(Long id, String description, Date cratedDate) {
        this.id = id;
        this.description = description;
        this.cratedDate = cratedDate;
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

    public Date getCratedDate() {
        return cratedDate;
    }

    public void setCratedDate(Date cratedDate) {
        this.cratedDate = cratedDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
