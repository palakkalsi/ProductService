package dev.pkalsi.productservice.controllers;

import dev.pkalsi.productservice.ProductNotFoundException;
import dev.pkalsi.productservice.dto.ErrorDto;
import dev.pkalsi.productservice.dto.ProductRequestDto;
import dev.pkalsi.productservice.dto.ProductResponseDto;
import dev.pkalsi.productservice.models.Category;
import dev.pkalsi.productservice.models.Product;
import dev.pkalsi.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
       Product product = productService.getProductById(id);
       return ProductResponseDto.from(product);
    }

    @GetMapping("/product")
    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product : products) {
            productResponseDtos.add(ProductResponseDto.from(product));
        }
        return productResponseDtos;
    }

    @PostMapping("/product")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        Product product = productService.createProduct(productRequestDto.getTitle(), productRequestDto.getDescription(),
                productRequestDto.getPrice(),productRequestDto.getImageUrl(),productRequestDto.getCategoryName());
        return ProductResponseDto.from(product);
    }

    @PutMapping("/product/update/{id}")
    public void updateProduct(){

    }

    @PatchMapping("/product/{id}")
    public ProductResponseDto partialUpdateProduct(@PathVariable("id") Long id, @RequestBody ProductRequestDto requestDto) throws ProductNotFoundException {
        Product product = requestDto.toProduct();
        Product updatedProduct = productService.partialUpdateProduct(id, product);
        return ProductResponseDto.from(updatedProduct);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteProduct(){
        //productService.deleteProduct(id);
    }

    /*@ExceptionHandler(NullPointerException.class)
    public ErrorDto nullPointerExceptionHandler(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Something went wrong");
        errorDto.setStatus("FAILED");
        return errorDto;
    }*/
}
