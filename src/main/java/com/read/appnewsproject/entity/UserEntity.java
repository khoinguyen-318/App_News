package com.read.appnewsproject.entity;

import com.read.appnewsproject.common.ERoleAccount;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "tbl_user")
public class UserEntity extends ParentEntity{
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "fullname")
    private String fullName;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private ERoleAccount role;

    @OneToMany(mappedBy = "account_id")
    private Collection<CommentEntity> comments;

    @OneToMany(mappedBy = "account")
    private Collection<FeedbackEntity> feedbacks;
}
