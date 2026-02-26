package com.rahmat.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahmat.product.model.produk;

@Repository
public interface ProdukRepository extends JpaRepository<produk, Long> {

    produk save(produk produk);

    
}