package com.mbhatia.springcloudcontractproducer.services.api;

import com.mbhatia.springcloudcontractproducer.DTOs.ProductCreateDTO;
import com.mbhatia.springcloudcontractproducer.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<Product> getProducts();
    Optional<Product> getProductById(Integer id);
    Integer createProduct(ProductCreateDTO newProductInfo);
    void deleteProductById(Integer Id);
}
