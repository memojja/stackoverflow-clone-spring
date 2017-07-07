package com.eteration.model.dto;

/**
 * Created by memojja on 07/07/2017.
 */
public class CommentDto {
    private String description;
    private String questionId;

    public CommentDto(){
    }
    public CommentDto(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
}
