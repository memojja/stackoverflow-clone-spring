package com.eteration.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by memojja on 04/07/2017.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @OneToOne
    private Vote vote;
    @ManyToOne(cascade = {CascadeType.ALL})
    private User user;

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Category> category;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Comment> comments;


    public Question(){
    }
    public Question(Long id, String description, Date cratedDate) {
        this.id = id;
        this.description = description;
        this.createdDate = cratedDate;
    }

    public Question(String description, Date cratedDate, Vote vote, User user, Set<Category> category, List<Comment> comments) {
        this.description = description;
        this.createdDate = cratedDate;
        this.vote = vote;
        this.user = user;
        this.category = category;
        this.comments = comments;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
