package contracts

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpStatus

Contract.make {
    description("Requesting an existing product with a valid ID should return HTTP OK with Product info")
    request {
        method GET()
        url("/v1/products/1")
    }
    response {
        status(HttpStatus.OK.value())
        body("{\n" +
                "    \"name\": \"TestProduct\",\n" +
                "    \"price\": 5.67,\n" +
                "    \"id\": 1\n" +
                "}")
    }
}