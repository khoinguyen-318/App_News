package com.read.appnewsproject.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "tbl_category")
@Data
public class CategoryEntity extends ParentEntity{
    @Column
    private String name;

    @Column(name = "metatitle")
    private String metaTitle;

    @Column(name = "displayorder")
    private int displayOrder;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Collection<ContentEntity> contents;
}
