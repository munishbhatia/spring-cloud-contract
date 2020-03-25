package com.mbhatia.springcloudcontractproducer.controllers;

import com.mbhatia.springcloudcontractproducer.DTOs.ProductCreateDTO;
import com.mbhatia.springcloudcontractproducer.models.Product;
import com.mbhatia.springcloudcontractproducer.services.api.ProductsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/v1/products")
public class ProductsController {
    private ProductsService productsService;

    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productsService.getProducts();
    }

    @GetMapping(path = "/{Id}")
    public Optional<Product> getProductById(@PathVariable Integer Id){
        return productsService.getProductById(Id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createProduct(@RequestBody ProductCreateDTO productCreateDTO){
        return productsService.createProduct(productCreateDTO);
    }

    @DeleteMapping(path = "/{Id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer Id){
        productsService.deleteProductById(Id);
    }
}
