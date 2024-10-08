package dev.pkalsi.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

public class Category extends BaseModal {
    private String name;
    private String description;
    /*@OneToMany
    private List<Product> featutredProducts;*/
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
