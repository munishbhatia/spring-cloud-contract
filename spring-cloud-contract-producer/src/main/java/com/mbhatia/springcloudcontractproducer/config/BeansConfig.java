package com.mbhatia.springcloudcontractproducer.config;

import com.mbhatia.springcloudcontractproducer.repositories.api.ProductsRepository;
import com.mbhatia.springcloudcontractproducer.repositories.implementations.InMemoryProductsRepository;
import com.mbhatia.springcloudcontractproducer.services.api.ProductsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@Configuration
//@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//        classes = ProductsRepository.class)}
//        basePackages = {//"com.mbhatia.springcloudcontractproducer.config",
//                "com.mbhatia.springcloudcontractproducer.controllers"
//        }
//        )
public class BeansConfig {
//    @Bean(name = "InMemoryProductsRepository")
//    public ProductsRepository productsRepository(){
//        return new InMemoryProductsRepository();
//    }
}
