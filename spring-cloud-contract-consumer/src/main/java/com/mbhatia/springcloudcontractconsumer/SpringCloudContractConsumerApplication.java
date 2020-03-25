package com.mbhatia.springcloudcontractconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.mbhatia.springcloudcontractconsumer.api_clients",
                "com.mbhatia.springcloudcontractconsumer.controllers"})
@EnableFeignClients
public class SpringCloudContractConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudContractConsumerApplication.class, args);
    }

}
