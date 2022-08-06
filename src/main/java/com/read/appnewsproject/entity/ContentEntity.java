package com.read.appnewsproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="tbl_content")
@Data
public class ContentEntity extends ParentEntity{
    @Column(columnDefinition = "TEXT")
    private String name;

    @Column
    private String image;

    @Column(name = "metatitle",columnDefinition = "TEXT")
    private String metaTitle;

    @Column(name = "shortdescription",columnDefinition = "TEXT")
    private String shortDescription;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "likecount")
    private Long likeCount;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "content_tag",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Collection<TagEntity> tags;

    @OneToMany(mappedBy = "content_id")
    private Collection<CommentEntity> comments;
}
