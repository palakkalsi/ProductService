package dev.pkalsi.productservice.services;

import dev.pkalsi.productservice.ProductNotFoundException;
import dev.pkalsi.productservice.dto.ErrorDto;
import dev.pkalsi.productservice.models.Category;
import dev.pkalsi.productservice.models.Product;
import dev.pkalsi.productservice.repositories.CategoryRepository;
import dev.pkalsi.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class ProductDBService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    ProductDBService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return getProductFromDB(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, Double price, String imageUrl, String categoryName) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(imageUrl);
        product.setCategory(getCategoryFromDB(categoryName));

        return productRepository.save(product);
    }

    @Override
    public Product partialUpdateProduct(Long id, Product product) throws ProductNotFoundException {
       Optional<Product> optionalProduct = productRepository.findById(id);
       if (optionalProduct.isEmpty()) {
           throw new ProductNotFoundException("Product that you want to update is not found.");
       }
       Product productToUpdate = optionalProduct.get();
       if(product.getTitle() != null){
           productToUpdate.setTitle(product.getTitle());
       }
       if(product.getDescription() != null){
           productToUpdate.setDescription(product.getDescription());
       }
       if(product.getPrice() != null){
           productToUpdate.setPrice(product.getPrice());
       }
       if(product.getImageUrl() != null){
           productToUpdate.setImageUrl(product.getImageUrl());
       }
       if(product.getCategory() != null && product.getCategory().getName() != null){
           productToUpdate.setCategory(getCategoryFromDB(product.getCategory().getName()));
       }
       return productRepository.save(productToUpdate);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {

    }

    private Category getCategoryFromDB(String categoryName) {
        Optional<Category> category = categoryRepository.findByName(categoryName);

        if(category.isEmpty()){  
            Category newCategory = new Category();
            newCategory.setName(categoryName);
            return categoryRepository.save(newCategory);
        }
        return category.get();
    }

    private Product getProductFromDB(Long id) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ProductNotFoundException("Product with " + id + " not found.");
        }
        return product.get();
    }
}
