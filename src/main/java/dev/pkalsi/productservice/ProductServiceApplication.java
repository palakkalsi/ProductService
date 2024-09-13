package dev.pkalsi.productservice;

import dev.pkalsi.productservice.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		Product product = new Product();
		product.setId(1L);
		product.getId();

	}

}
