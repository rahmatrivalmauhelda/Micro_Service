package com.rahmat.pelanggan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rahmat.pelanggan.model.pelanggane;

@Repository
public interface PelangganRepository extends JpaRepository<pelanggane, Long> {

    
}