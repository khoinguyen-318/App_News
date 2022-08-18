package com.read.appnewsproject.entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isdeleted")
    private Boolean isDeleted;

    @Temporal(TemporalType.DATE)
    @Column(name = "createddate",updatable = false)
    @CreatedDate
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "modifieddate")
    @LastModifiedDate
    private Date modifiedDate;

    @Column(name = "createdby",updatable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy;
}
