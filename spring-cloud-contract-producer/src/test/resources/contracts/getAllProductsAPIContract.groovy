package contracts

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

Contract.make {
    request {
        method GET()
        url("/v1/products")
    }
    response {
        status(HttpStatus.OK.value())
        headers {
            contentType(MediaType.APPLICATION_JSON_VALUE)
        }
        body("[{\n" +
                "    \"name\": \"TestProduct\",\n" +
                "    \"price\": 5.67,\n" +
                "    \"id\": 1\n" +
                "}]")
    }
}