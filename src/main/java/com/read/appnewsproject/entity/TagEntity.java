package com.read.appnewsproject.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Data
@Table(name = "tbl_tag")
public class TagEntity extends ParentEntity{
    @Column
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Collection<ContentEntity> contents;
}
