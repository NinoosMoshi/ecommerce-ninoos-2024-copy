package com.ninos.service.category;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ninos.mapper.CategoryMapper;
import com.ninos.model.dto.CategoryDTO;
import com.ninos.model.entity.Category;
import com.ninos.repository.CategoryRepository;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;


    @Override
    public Page<CategoryDTO> getAllCategories(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Category> categoriesPage = categoryRepository.findAll(pageRequest);
        return new PageImpl<>(categoriesPage.getContent().stream().map(category -> mapper.entityToDto(category)).collect(Collectors.toList()), pageRequest, categoriesPage.getTotalElements());
    }


}
