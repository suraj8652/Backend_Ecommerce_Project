package dev.suraj.productservice.services;

import dev.suraj.productservice.dto.FakeStoreProductDto;
import dev.suraj.productservice.dto.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String BaseProductRequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto products){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(BaseProductRequestUrl, products, GenericProductDto.class);

        return response.getBody();
    }


    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        //response.getStatusCode();
        return product;
        //return new Product();
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //ResponseEntity<List<FakeStoreProductDto>> response = restTemplate.getForEntity(BaseProductRequestUrl, List<FakeStoreProductDto>.class);

        //to support backward compatibility - type eraser at run time delete the Data type i.e. FakeStoreProductDto hence below will work right
        //ResponseEntity<List> response = restTemplate.getForEntity(BaseProductRequestUrl, List.class);

        //Array can also work
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(BaseProductRequestUrl, FakeStoreProductDto[].class);
        //now we want to create to GenericProductDto from fakeSToreProductDto

        List<GenericProductDto> answer = new ArrayList<>();

        //if we have used List then response.getBody() only would have worked in for loop

        for(FakeStoreProductDto fakeStoreProductDto : Arrays.stream(response.getBody()).toList()){
            GenericProductDto product = new GenericProductDto();
            product.setImage(fakeStoreProductDto.getImage());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setCategory(fakeStoreProductDto.getCategory());

            answer.add(product);

        }
        return answer;
    }
}
