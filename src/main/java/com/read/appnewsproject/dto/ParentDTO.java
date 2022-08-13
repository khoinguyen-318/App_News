package com.read.appnewsproject.dto;

import lombok.*;

import java.util.Date;

@Data
public class ParentDTO {
    private Long id;

    private Boolean isDeleted;

    private Date createdDate;

    private Date modifiedDate;

    private String createdBy;

    private String modifiedBy;
}
