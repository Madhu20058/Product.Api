package repository;



	import java.util.List;

	
	import org.springframework.data.jpa.repository.JpaRepository;

import dto.Product;

	public interface ProductRepository extends JpaRepository<Product, Integer>{

		List<Product> findByPriceGreaterThanEqual(double price);

		List<Product> findByName(String name);

		List<Product> findByStockBetween(int min, int max);

		
	}

