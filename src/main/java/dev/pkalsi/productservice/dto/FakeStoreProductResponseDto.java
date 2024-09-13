package dev.pkalsi.productservice.dto;

import dev.pkalsi.productservice.models.Category;
import dev.pkalsi.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    private Long id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.getId());
        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setPrice(Double.valueOf(this.getPrice()));
        product.setImageUrl(this.getImage());

        Category category = new Category();
        category.setName(this.getCategory());
        product.setCategory(category);

        return product;
    }
}
