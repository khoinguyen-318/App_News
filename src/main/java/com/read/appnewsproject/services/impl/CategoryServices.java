package com.read.appnewsproject.services.impl;

import com.read.appnewsproject.dto.CategoryDTO;
import com.read.appnewsproject.entity.CategoryEntity;
import com.read.appnewsproject.repository.CategoryRepository;
import com.read.appnewsproject.services.ICategoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices implements ICategoryServices {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CategoryDTO> listAll(Pageable pageable){
        return repository.findAll(pageable)
                .map(categoryEntity -> modelMapper.map(categoryEntity,CategoryDTO.class)
                ).toList();
    }
    @Override
    public CategoryDTO addNewCategory(CategoryDTO categoryDTO){
        CategoryEntity entity = repository.save(modelMapper.map(categoryDTO, CategoryEntity.class));
        return modelMapper.map(entity,CategoryDTO.class);
    }
    @Override
    public void deleteCategory(Long id){
        repository.deleteById(id);
    }
    @Override
    public CategoryDTO updateCategory(CategoryDTO newCategory, Long id){
        return repository.findById(id)
                .map(existCategory->{
                    modelMapper.map(newCategory,existCategory);
                    existCategory.setId(id);
                    return modelMapper.map(existCategory,CategoryDTO.class);
                }).orElseThrow(); //exception
    }
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    @Override
    public CategoryDTO findById(Long id){
        return repository.findById(id)
                .map(existCategory->modelMapper.map(existCategory,CategoryDTO.class))
                .orElseThrow(); //exception
    }
}
