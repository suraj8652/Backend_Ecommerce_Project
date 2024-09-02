package dev.suraj.productservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long Id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;
}
