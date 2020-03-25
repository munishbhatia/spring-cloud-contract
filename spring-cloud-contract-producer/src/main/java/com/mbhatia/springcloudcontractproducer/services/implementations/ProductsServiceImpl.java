package com.mbhatia.springcloudcontractproducer.services.implementations;

import com.mbhatia.springcloudcontractproducer.DTOs.ProductCreateDTO;
import com.mbhatia.springcloudcontractproducer.models.Product;
import com.mbhatia.springcloudcontractproducer.repositories.api.ProductsRepository;
import com.mbhatia.springcloudcontractproducer.services.api.ProductsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductsServiceImpl implements ProductsService {
    private ProductsRepository productsRepository;
    private Random randomGen = new Random();

    public ProductsServiceImpl(@Qualifier("inMemoryProductsRepository") ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productsRepository.fetchProducts();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productsRepository.fetchProductById(id);
    }

    @Override
    public Integer createProduct(ProductCreateDTO newProductInfo) {
        Product newProduct = new Product(randomGen.nextInt(1000), newProductInfo.getName(), newProductInfo.getPrice());
        return productsRepository.saveProduct(newProduct);
    }

    @Override
    public void deleteProductById(Integer Id) {
        if(getProductById(Id).isPresent())
            productsRepository.deleteProductById(Id);
        else
            throw new HttpServerErrorException(HttpStatus.NOT_FOUND, String.format("Product with Id %s not found", Id));
    }
}
