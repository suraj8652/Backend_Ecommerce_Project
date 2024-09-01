package dev.suraj.productservice.services;

import dev.suraj.productservice.dto.GenericProductDto;
import dev.suraj.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}
