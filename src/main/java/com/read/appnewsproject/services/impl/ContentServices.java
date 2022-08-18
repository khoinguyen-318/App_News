package com.read.appnewsproject.services.impl;

import com.read.appnewsproject.dto.ContentDTO;
import com.read.appnewsproject.entity.ContentEntity;
import com.read.appnewsproject.repository.ContentRepository;
import com.read.appnewsproject.services.IContentServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServices implements IContentServices {
    @Autowired
    private ContentRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ContentDTO> getAllPaging(Pageable pageable){
        return repository.findAll(pageable)
                .map(content->modelMapper.map(content,ContentDTO.class))
                .toList();
    }
    @Override
    public ContentDTO addNewContent(ContentDTO newContent){
        ContentEntity entity= repository.save(modelMapper.map(newContent, ContentEntity.class));
        return modelMapper.map(entity,ContentDTO.class);
    }
    @Override
    public ContentDTO updateContent(ContentDTO newContent, Long id){
        return repository.findById(id)
                .map(existContent->{
                    modelMapper.map(newContent,existContent);
                    existContent.setId(id);
                    return modelMapper.map(existContent,ContentDTO.class);
                }).orElseThrow(); //Exception
    }
    @Override
    public ContentDTO findById(Long id){
        return repository.findById(id)
                .map(existContent-> modelMapper.map(existContent,ContentDTO.class)
                ).orElseThrow(); //Exception
    }
    @Override
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
