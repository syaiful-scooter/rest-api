package com.syaiful.api.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syaiful.api.dto.ProductDTO;
import com.syaiful.api.service.ProductService;

@RestController
@RequestMapping("/v1/master/produk")
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/data")
	public List<ProductDTO> index() {
		return service.getAll();
	}

	@GetMapping("/{op}")
	public List<ProductDTO> cariOp(@PathVariable String op) {
		return service.cariOperator(op);
	}

	@GetMapping("/id/{kode}")
	public ProductDTO kode(@PathVariable("kode") int kode) {
		return service.getById(kode);
	}

	@GetMapping("/kodeproduk/{kode}")
	public ProductDTO kode(@PathVariable("kode") String kode_produk) {
		return service.getByKode_produk(kode_produk);
	}

	@PostMapping("")
	public Map<String, Object> store(@RequestBody ProductDTO pDto) {
		if (pDto.getId() > 0) {
			return Map.of("status", false, "message", "Invalid Payload");
		}
		service.save(pDto);
		return Map.of("status", true, "message", "Simpan Berhasil");
	}
	
	@PutMapping("")
	public Map<String, Object> update(@RequestBody ProductDTO pDto) {

		if (pDto.getId() == 0) {
			return Map.of("status", false, "message", "invalid payload");
		}

		service.save(pDto);
		return Map.of("status", true, "message", "Simpan Berhasil");
	}
}
