package com.syaiful.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syaiful.api.dto.ProductDTO;
import com.syaiful.api.models.Product;
import com.syaiful.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	public List<Product> get() {
		return repo.findAll();
	}

	public ProductDTO getById(int id) {
//		ProductDTO pDto = new ProductDTO();
		ProductDTO pDto = null;
		Product product = repo.findById(id).orElse(null);
		if (product != null) {
			pDto = new ProductDTO();
			pDto.setId(product.getId());
			pDto.setKode_produk(product.getKodeProduk());
			pDto.setNama(product.getNama_produk());
			pDto.setHarga(String.valueOf(product.getHarga()));
			pDto.setOperator(product.getOperator());
			pDto.setTipe(product.getTipe());

		}
		return pDto;
	}

	public List<ProductDTO> getAll() {
		List<ProductDTO> ls = new ArrayList<ProductDTO>();
		List<Product> produk = repo.findAll();

		for (Product pro : produk) {
			ProductDTO proDto = new ProductDTO();

			proDto.setId(pro.getId());
			proDto.setKode_produk(pro.getKodeProduk());
			proDto.setNama(pro.getNama_produk());
			proDto.setOperator(pro.getOperator());
			proDto.setTipe(pro.getTipe());
			proDto.setHarga(String.valueOf(pro.getHarga()));

			ls.add(proDto);
		}
		return ls;
	}

	public List<ProductDTO> cariOperator(String keyword) {
		List<ProductDTO> ls = new ArrayList<ProductDTO>();
		List<Product> produk = repo.findByOperatorContaining(keyword);

		for (Product pro : produk) {
			ProductDTO proDto = new ProductDTO();

			proDto.setId(pro.getId());
			proDto.setKode_produk(pro.getKodeProduk());
			proDto.setNama(pro.getNama_produk());
			proDto.setOperator(pro.getOperator());
			proDto.setTipe(pro.getTipe());
			proDto.setHarga(String.valueOf(pro.getHarga()));

			ls.add(proDto);
		}
		return ls;
	}

	public ProductDTO getByKode_produk(String kode_produk) {
		ProductDTO pDto = null;
		Product product = repo.findByKodeProduk(kode_produk).orElse(null);
		if (product != null) {
			pDto = new ProductDTO();
			pDto.setId(product.getId());
			pDto.setKode_produk(product.getKodeProduk());
			pDto.setNama(product.getNama_produk());
			pDto.setHarga(String.valueOf(product.getHarga()));
			pDto.setOperator(product.getOperator());
			pDto.setTipe(product.getTipe());

		}
		return pDto;
	}

	public void simpan(String kode_produk, String operator, String tipe, String nama, String harga) {
		Product p = new Product();
		p.setKodeProduk(kode_produk);
		p.setNama_produk(nama);
		p.setTipe(tipe);
		p.setOperator(operator);
		p.setHarga(Double.parseDouble(harga));

		repo.save(p);
	}

	public void save(ProductDTO pDto) {

		String kode = pDto.getKode_produk();
		String nama = pDto.getNama();
		String tipe = pDto.getTipe();
		String operator = pDto.getOperator();
		String harga = pDto.getHarga();

		Product p = repo.findById(pDto.getId()).orElse(null);
		if (p == null) {
			p = new Product();
		}
		p.setKodeProduk(kode);
		p.setNama_produk(nama);
		p.setTipe(tipe);
		p.setOperator(operator);
		p.setHarga(Double.parseDouble(harga));

		repo.save(p);

	}
	
	
}
