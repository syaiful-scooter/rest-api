package com.syaiful.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syaiful.api.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByOperatorContaining(String operator);
//	List<Product> findByTipe(String Tipe);
	
//	List<Product> findByKode_Produk(String kode_Produk);
	Optional<Product> findByKodeProduk(String kode_produk);
	
	
	
}
