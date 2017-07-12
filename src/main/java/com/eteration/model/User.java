package com.eteration.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by memojja on 04/07/2017.
 */
@Table(name = "author")
@Entity
public class User {

    @Column(name = "user_id")
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name="role")
    private String roleName;

    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<Question> questions;

    public User(){}

    public User(String username, String email, String phone, String password,String roleName) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.roleName=roleName;
    }

    public User(String username, String email, String phone, String password,String roleName, List<Comment> comments, List<Question> questions) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.comments = comments;
        this.questions = questions;
        this.roleName=roleName;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


}
