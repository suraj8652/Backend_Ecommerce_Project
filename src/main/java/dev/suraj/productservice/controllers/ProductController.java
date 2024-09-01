package dev.suraj.productservice.controllers;

import dev.suraj.productservice.dto.GenericProductDto;
import dev.suraj.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products/")
public class ProductController {

    //We can provide dependency via field, constructor and setter
    //filed injection
    //@Autowired
    private ProductService productService;

    //Constructor injection - best practise
   // @Autowired - but not needed spring automatically understand
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    //setter injection
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

    @GetMapping
    public void getAllProducts(){

    }

    //localhost:8080/products/123

    @GetMapping("{id}")
    public GenericProductDto getProductByID(@PathVariable("id") Long id){
        //return "Here is the product id " + id;
        return productService.getProductById(id);

    }

    @DeleteMapping("{id}")
    public void deleteProductByID(){

    }

    @PostMapping()
    public String creatProduct(){
        return "Created new Product " + UUID.randomUUID();

    }

    @PutMapping("{}")
    public void updateProductById(){

    }
}
