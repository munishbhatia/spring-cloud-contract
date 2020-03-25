package com.mbhatia.springcloudcontractproducer.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductCreateDTO {
    String name;
    Double price;
}
