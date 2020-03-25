package com.mbhatia.springcloudcontractconsumer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

//@Getter
//@AllArgsConstructor
@Data
public class Product {
    Integer Id;
    String name;
    Double price;
}
