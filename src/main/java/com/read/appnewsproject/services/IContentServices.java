package com.read.appnewsproject.services;

import com.read.appnewsproject.dto.ContentDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContentServices {
    List<ContentDTO> getAllPaging(Pageable pageable);

    ContentDTO addNewContent(ContentDTO newContent);

    ContentDTO updateContent(ContentDTO newContent, Long id);

    ContentDTO findById(Long id);

    void deleteById(Long id);
}
