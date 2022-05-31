package it.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.billing.entity.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {

}
