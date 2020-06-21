package com.oklimenko.dockerspring.dto;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
}
