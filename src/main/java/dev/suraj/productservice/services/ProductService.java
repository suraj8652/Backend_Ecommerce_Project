package dev.suraj.productservice.services;

import dev.suraj.productservice.dto.GenericProductDto;
import dev.suraj.productservice.models.Product;

public interface ProductService {
        GenericProductDto getProductById(Long id);


}
