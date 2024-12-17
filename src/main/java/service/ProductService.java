package service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.Product;
import repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public ResponseEntity<Object> saveProduct1(Product product) {
		repository.save(product);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", product);

		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> saveProducts(List<Product> products) {
		repository.saveAll(products);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Product Added Success");
		map.put("data", products);

		return new ResponseEntity<Object>(map, HttpStatus.CREATED);
	}

	public ResponseEntity<Object> fetchAllProducts() {
		List<Product> list = repository.findAll();
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found");

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchById(int id) {
		Optional<Product> optional = repository.findById(id);
		if(optional.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found with Id: "+id);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		}else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", optional.get());

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByName(String name) {
		List<Product> list = repository.findByName(name);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found with Name :"+name);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByPriceGreater1(double price) {
		List<Product> list = repository.findByPriceGreaterThanEqual(price);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found Price Greater Than: "+price);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByStockBetween(int min, int max) {
		List<Product> list = repository.findByStockBetween(min,max);
		if (list.isEmpty()) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("error", "No Products Found Stock Between: "+min+" and "+max);

			return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "Products Found");
			map.put("data", list);

			return new ResponseEntity<Object>(map, HttpStatus.OK);
		}
	}

	public ResponseEntity<Object> fetchByPriceGreater11(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<Object> fetchByPriceGreater(double price) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<Object> saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
