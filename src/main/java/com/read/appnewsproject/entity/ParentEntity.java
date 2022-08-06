package com.read.appnewsproject.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isdeleted")
    private boolean isDeleted;

    @Temporal(TemporalType.DATE)
    @Column(name = "createddate")
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "modifieddate")
    private Date modifiedDate;

    @Column(name = "createdby")
    private Date createdBy;

    @Column(name = "modifiedby")
    private Date modifiedBy;
}
