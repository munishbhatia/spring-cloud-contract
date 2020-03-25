package com.mbhatia.springcloudcontractconsumer.api_clients.contract_tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestPropertySource("classpath:test-application.properties")
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
ids = {"com.mbhatia:spring-cloud-contract-producer:+:stubs:9090"})
public class ProductsServiceClientAPIContractTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProductsCompliesToContract() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/prodconsumer/products")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"name\":\"TestProduct\",\"price\":5.67,\"id\":1}]"));
    }
}
