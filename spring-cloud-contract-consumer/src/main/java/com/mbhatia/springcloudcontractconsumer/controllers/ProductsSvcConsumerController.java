package com.mbhatia.springcloudcontractconsumer.controllers;

import com.mbhatia.springcloudcontractconsumer.api_clients.products_service.ProductsServiceClient;
import com.mbhatia.springcloudcontractconsumer.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/prodconsumer/products")
public class ProductsSvcConsumerController {
    private ProductsServiceClient productsServiceClient;

    public ProductsSvcConsumerController(ProductsServiceClient productsServiceClient) {
        this.productsServiceClient = productsServiceClient;
    }

    @GetMapping
    public List<Product> getProducts(){
        List<Product> response =  productsServiceClient.getProducts();
        return response;
    }
}
