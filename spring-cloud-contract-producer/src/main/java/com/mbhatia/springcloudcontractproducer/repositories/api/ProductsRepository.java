package com.mbhatia.springcloudcontractproducer.repositories.api;

import com.mbhatia.springcloudcontractproducer.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository {
    List<Product> fetchProducts();
    Optional<Product> fetchProductById(Integer id);
    Integer saveProduct(Product newProduct);
    void deleteProductById(Integer Id);
}
