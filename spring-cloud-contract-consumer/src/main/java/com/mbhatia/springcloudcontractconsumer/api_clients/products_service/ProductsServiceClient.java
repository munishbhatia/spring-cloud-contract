package com.mbhatia.springcloudcontractconsumer.api_clients.products_service;

import com.mbhatia.springcloudcontractconsumer.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "products-service-client", url = "${products-service-client.ribbon.listOfServers}", path = "/v1/products")
public interface ProductsServiceClient {
    @GetMapping
    List<Product> getProducts();

    @GetMapping(path = "/{Id}")
    Optional<Product> getProductById(@PathVariable Integer Id);

    @DeleteMapping(path = "/{Id}")
    void deleteProductById(@PathVariable Integer Id);
}
