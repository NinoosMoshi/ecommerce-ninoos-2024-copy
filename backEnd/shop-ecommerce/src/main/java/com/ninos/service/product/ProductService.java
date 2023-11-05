package com.ninos.service.product;

import org.springframework.data.domain.Page;

import com.ninos.model.dto.ProductDTO;

public interface ProductService {

    Page<ProductDTO> getAllProducts(int page, int size);

    Page<ProductDTO> getProductsByCategoryId(Long id, int page, int size);

    Page<ProductDTO> findByNameContaining(String name, int page, int size);

    ProductDTO getProductById(Long id);

}
