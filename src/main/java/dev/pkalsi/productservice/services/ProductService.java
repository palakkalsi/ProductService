package dev.pkalsi.productservice.services;

import dev.pkalsi.productservice.ProductNotFoundException;
import dev.pkalsi.productservice.dto.ProductResponseDto;
import dev.pkalsi.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getProductById(Long id) throws ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product createProduct(String title, String description, Double price,
                                            String imageUrl, String categoryName);
    public Product partialUpdateProduct(Long id, Product product) throws ProductNotFoundException;
    void deleteProduct(Long id) throws ProductNotFoundException;

}
