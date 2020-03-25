package contracts

import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpStatus

Contract.make {
    description("An incorrect response status has been intentionally used in response segment " +
            "to showcase a failed contract")
    request {
        method DELETE()
        url("/v1/products/1")
    }
    response {
        status(HttpStatus.NO_CONTENT.value())
    }
}