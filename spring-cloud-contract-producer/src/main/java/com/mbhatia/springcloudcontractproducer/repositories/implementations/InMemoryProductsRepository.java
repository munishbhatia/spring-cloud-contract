package com.mbhatia.springcloudcontractproducer.repositories.implementations;

import com.mbhatia.springcloudcontractproducer.models.Product;
import com.mbhatia.springcloudcontractproducer.repositories.api.ProductsRepository;

import java.util.*;

public class InMemoryProductsRepository implements ProductsRepository {
    static Map<Integer, Product> productMap = new HashMap<>(5);

    static {
        productMap.put(1, new Product(10, "Test", 12.0));
    }

    @Override
    public List<Product> fetchProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Optional<Product> fetchProductById(Integer id) {
        if(productMap.containsKey(id))
            return Optional.of(productMap.get(id));
        return Optional.empty();
    }

    @Override
    public Integer saveProduct(Product newProduct) {
        productMap.put(newProduct.getId(), newProduct);
        return newProduct.getId();
    }

    @Override
    public void deleteProductById(Integer Id) {
        if(productMap.containsKey(Id))
            productMap.remove(Id);
    }
}
