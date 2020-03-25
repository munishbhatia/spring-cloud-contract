package com.mbhatia.springcloudcontractproducer;

import com.mbhatia.springcloudcontractproducer.repositories.api.ProductsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableAutoConfiguration
@ComponentScan(includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        classes = ProductsRepository.class)})
public class SpringCloudContractProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudContractProducerApplication.class, args);
    }
}
