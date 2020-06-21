package com.oklimenko.dockerspring.service;

import com.oklimenko.dockerspring.entity.ProductEntity;
import com.oklimenko.dockerspring.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductsService {

    private final ProductRepository productRepository;

    @Cacheable(value = "products")
    public List<ProductEntity> cachedSearch(String criteriaString) {
        return regularSearch(criteriaString);
    }

    public List<ProductEntity> regularSearch(String criteriaString) {
        return productRepository.findByStringCriteria(criteriaString);
    }
}
