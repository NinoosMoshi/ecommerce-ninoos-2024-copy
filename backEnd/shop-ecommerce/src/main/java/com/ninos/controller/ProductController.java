package com.ninos.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.dto.ProductDTO;
import com.ninos.service.product.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/get-all")
    public Page<ProductDTO> getAllProducts(@RequestParam(name = "page", defaultValue = "0") int page,
                                           @RequestParam(name = "size", defaultValue = "100") int size){

        return productService.getAllProducts(page, size);
    }


    // http://localhost:8080/api/v1/products?id=<categoryId>
    @GetMapping()
    public Page<ProductDTO> productsByCategoryId(@RequestParam Long id,
                                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                                 @RequestParam(name = "size", defaultValue = "100") int size){
        return productService.getProductsByCategoryId(id, page, size);
    }


    // http://localhost:8080/api/v1/products/search?name=<productName>
    @GetMapping("/search")
    public Page<ProductDTO> searchCourses(@RequestParam(name = "name", defaultValue = "") String name,
                                         @RequestParam(name = "page", defaultValue = "0") int page,
                                         @RequestParam(name = "size", defaultValue = "100") int size){
        return productService.findByNameContaining(name, page, size);
    }


    // http://localhost:8080/api/v1/products/<productId>
    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Long id){
       return productService.getProductById(id);
    }



}
