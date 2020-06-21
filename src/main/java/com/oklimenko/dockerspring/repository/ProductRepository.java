package com.oklimenko.dockerspring.repository;

import com.oklimenko.dockerspring.dto.Product;
import com.oklimenko.dockerspring.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query ("select p from ProductEntity p where p.firstName like %:criteriaString% or " +
            " p.lastName  like %:criteriaString% or " +
            " p.position  like %:criteriaString% or " +
            " p.department like %:criteriaString% ")
    List<ProductEntity> findByStringCriteria(@Param("criteriaString") String criteriaString);
}