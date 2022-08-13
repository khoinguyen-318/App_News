package com.read.appnewsproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends ParentDTO {
    private String name;

    private String metaTitle;

    private int displayOrder;
}
