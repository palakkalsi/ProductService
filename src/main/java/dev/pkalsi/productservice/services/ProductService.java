package dev.pkalsi.productservice.services;

import dev.pkalsi.productservice.models.Product;

public interface ProductService {
    public Product getProductById(Long id);
}
