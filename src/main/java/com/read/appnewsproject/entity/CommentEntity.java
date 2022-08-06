package com.read.appnewsproject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tbl_comment")
@Data
public class CommentEntity extends ParentEntity{
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserEntity account_id;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private ContentEntity content_id;
}
