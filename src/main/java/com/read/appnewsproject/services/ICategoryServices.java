package com.read.appnewsproject.services;

import com.read.appnewsproject.dto.CategoryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryServices {
    List<CategoryDTO> listAll(Pageable pageable);

    CategoryDTO addNewCategory(CategoryDTO categoryDTO);

    void deleteCategory(Long id);

    CategoryDTO updateCategory(CategoryDTO newCategory, Long id);

    void deleteById(Long id);

    CategoryDTO findById(Long id);
}
