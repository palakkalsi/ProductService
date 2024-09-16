package dev.pkalsi.productservice.services;

import dev.pkalsi.productservice.ProductNotFoundException;
import dev.pkalsi.productservice.models.Product;
import dev.pkalsi.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ProductDBService implements ProductService{

    private ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, Double price, String imageUrl, String categoryName) {
        Product product = new Product();
        product.setTitle(title);
        productRepository.save(product);
        return product;
    }
}
