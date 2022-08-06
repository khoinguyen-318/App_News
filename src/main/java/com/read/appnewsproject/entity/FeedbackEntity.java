package com.read.appnewsproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_feedback")
@Data
public class FeedbackEntity extends ParentEntity{
    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserEntity account;
}
