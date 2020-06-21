package com.oklimenko.dockerspring.controller;

import com.oklimenko.dockerspring.config.ApplicationConfiguration;
import com.oklimenko.dockerspring.entity.ProductEntity;
import com.oklimenko.dockerspring.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductsController {

    private final ApplicationConfiguration config;
    private final ProductsService productsService;

    @GetMapping("/product")
    public List<ProductEntity> findProducts(@RequestParam("criteriaString") String criteriaString) {
        if ("1".equals(config.getCacheEnabled())) {
            return productsService.cachedSearch(criteriaString);
        } else {
            return productsService.regularSearch(criteriaString);

        }
    }
}
