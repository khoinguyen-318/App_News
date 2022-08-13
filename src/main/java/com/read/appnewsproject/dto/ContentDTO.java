package com.read.appnewsproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDTO extends ParentDTO {
    private String name;

    private String image;

    private String metaTitle;

    private String shortDescription;

    private String description;

    private Long likeCount;
}
