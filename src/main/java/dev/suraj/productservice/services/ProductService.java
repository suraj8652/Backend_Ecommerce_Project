package dev.suraj.productservice.services;

import dev.suraj.productservice.dto.GenericProductDto;
import dev.suraj.productservice.models.Product;

import java.util.List;

public interface ProductService {
        GenericProductDto createProduct(GenericProductDto products);

        GenericProductDto getProductById(Long id);

        List<GenericProductDto> getAllProducts();


}
