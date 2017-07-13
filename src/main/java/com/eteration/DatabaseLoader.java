package com.eteration;

import com.eteration.model.*;
import com.eteration.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by memojja on 11/07/2017.
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final QuestionService questionService;
    private final UserService userService;
    private final CategoryService categoryService;
    private final CommentService commentService;
    private final VoteService voteService;
    private final SecurityService securityService;

    @Autowired
    public DatabaseLoader(QuestionService questionService, UserService userService, CategoryService categoryService, CommentService commentService, VoteService voteService, SecurityService securityService) {
        this.questionService = questionService;
        this.userService = userService;
        this.categoryService = categoryService;
        this.commentService = commentService;
        this.voteService = voteService;
        this.securityService = securityService;
    }

    @Override
    public void run(String... strings) throws Exception {

        Vote vote = new Vote(11);
        User user1 = new User("ahmet","ali@eteration.com","78945612","123456","USER");
        user1.setPassword(securityService.bCryptPasswordEncoder().encode(user1.getPassword()));

        Comment comment= new Comment("desc1",vote);
        Category category = new Category("category1");

        HashSet<Category> categories = new HashSet<Category>();
        categories.add(category);

        ArrayList<Comment> comments = new ArrayList<Comment>();
        comments.add(comment);

        Question question = new Question("question",new Date(),vote,user1,
                categories,
                comments);
        Question question1 =new Question();


        List<Question> questions =new ArrayList<Question>();
        questions.add(question);

        User user = new User("ali","me@eteration.com","5346233845","123456","ADMIN",comments,questions);
        user.setPassword(securityService.bCryptPasswordEncoder().encode(user.getPassword()));

        questionService.save(question);
        questionService.save(question1);
        userService.save(user);
        voteService.save(vote);
        categoryService.save(category);
        commentService.save(comment);

    }
}
