package com.niit.userFurnitureService.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Furniture {
    @Id
    private int id;
    private String name;
    private int price;
}
