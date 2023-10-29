package com.ninos.service.product;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ninos.mapper.ProductMapper;
import com.ninos.model.dto.ProductDTO;
import com.ninos.model.entity.Product;
import com.ninos.repository.ProductRepository;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public Page<ProductDTO> getAllProducts(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> productsPage = productRepository.findAll(pageRequest);
        return new PageImpl<>(productsPage.getContent().stream().map(product -> productMapper.entityToDto(product)).collect(Collectors.toList()), pageRequest, productsPage.getTotalElements());
    }


    @Override
    public Page<ProductDTO> getProductsByCategoryId(Long id, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> productsByCategoryId = productRepository.findByCategoryId(id, pageRequest);
        return new PageImpl<>(productsByCategoryId.getContent().stream().map(product -> productMapper.entityToDto(product)).collect(Collectors.toList()), pageRequest, productsByCategoryId.getTotalElements());
    }


    @Override
    public Page<ProductDTO> findByNameContaining(String name, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Product> productsPage = productRepository.findByNameContaining(name,pageRequest);
        return new PageImpl<>(productsPage.getContent().stream().map(product -> productMapper.entityToDto(product)).collect(Collectors.toList()),pageRequest, productsPage.getTotalElements());
    }


    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Product With ID " + id + " Not Found"));
        return productMapper.entityToDto(product);
    }


}
