package dev.pkalsi.productservice.dto;

import dev.pkalsi.productservice.models.Category;
import dev.pkalsi.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;


    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);

        Category category = new Category();
        category.setName(this.categoryName);
        product.setCategory(category);

        return product;
    }
}
