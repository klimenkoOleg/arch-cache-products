package com.oklimenko.dockerspring.controller;

import com.oklimenko.dockerspring.config.ApplicationConfiguration;
import com.oklimenko.dockerspring.dto.Product;
import com.oklimenko.dockerspring.entity.ProductEntity;
import com.oklimenko.dockerspring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductsController {

    private final ApplicationConfiguration config;
    private final ProductRepository productRepository;

    @Cacheable(value = "products")
//    @Cacheable(value = "post-single", key = "#id", unless = "#result.shares < 500")
    @GetMapping("/product")
    public List<ProductEntity> findProducts(@RequestParam("criteriaString") String criteriaString) {
        List<ProductEntity> result = productRepository.findByStringCriteria(criteriaString);
        /*if ("1".equals(config.getCacheEnabled())) {
            // use cache
            List<Product> result = productRepository.findByStringCriteria(criteriaString);
        } else {
            //direct search
        }*/
        return result;
    }
}
