package com.mbhatia.springcloudcontractproducer.contract_tests;

import com.mbhatia.springcloudcontractproducer.controllers.ProductsController;
import com.mbhatia.springcloudcontractproducer.models.Product;
import com.mbhatia.springcloudcontractproducer.repositories.api.ProductsRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@DirtiesContext
@AutoConfigureMessageVerifier
@Ignore("No Tests Base Class")
abstract public class ContractVerifierBaseTest {
    @Autowired
    private ProductsController productsController;
    @MockBean(name = "InMemoryProductsRepository")
    ProductsRepository productsRepository;

    @Before
    public void setUp(){
        Product testProduct = new Product(1, "TestProduct", 5.67);
        List<Product> products = new ArrayList<>(1);
        products.add(testProduct);

        when(productsRepository.fetchProducts()).thenReturn(products);
        when(productsRepository.fetchProductById(anyInt())).thenReturn(Optional.of(testProduct));
        when(productsRepository.saveProduct(any(Product.class))).thenReturn(testProduct.getId());
        doNothing().when(productsRepository).deleteProductById(anyInt());

        StandaloneMockMvcBuilder productsControllerMockMvc = MockMvcBuilders.standaloneSetup(productsController);
        RestAssuredMockMvc.standaloneSetup(productsControllerMockMvc);
    }
}
