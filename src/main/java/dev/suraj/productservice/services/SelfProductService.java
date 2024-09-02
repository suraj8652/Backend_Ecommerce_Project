package dev.suraj.productservice.services;

import dev.suraj.productservice.dto.GenericProductDto;
import dev.suraj.productservice.models.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    @Override
    public GenericProductDto createProduct(GenericProductDto products) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }
}
