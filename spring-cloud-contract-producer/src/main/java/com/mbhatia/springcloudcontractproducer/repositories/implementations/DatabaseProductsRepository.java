package com.mbhatia.springcloudcontractproducer.repositories.implementations;

import com.mbhatia.springcloudcontractproducer.models.Product;
import com.mbhatia.springcloudcontractproducer.repositories.api.ProductsRepository;

import java.util.List;
import java.util.Optional;

public class DatabaseProductsRepository implements ProductsRepository {
    @Override
    public List<Product> fetchProducts() {
        return null;
    }

    @Override
    public Optional<Product> fetchProductById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Integer saveProduct(Product newProduct) {
        return null;
    }

    @Override
    public void deleteProductById(Integer Id) {

    }
}
