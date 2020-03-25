package com.mbhatia.springcloudcontractproducer.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Product {
    Integer Id;
    String name;
    Double price;
}
