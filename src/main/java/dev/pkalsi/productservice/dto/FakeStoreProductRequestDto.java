package dev.pkalsi.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDto {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;

    public static FakeStoreProductRequestDto from(String title, String description, Double price, String imageUrl, String categoryName) {
        FakeStoreProductRequestDto dto = new FakeStoreProductRequestDto();
        dto.title = title;
        dto.description = description;
        dto.price = price;
        dto.imageUrl = imageUrl;
        dto.categoryName = categoryName;
        return dto;
    }
}
