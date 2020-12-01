package com.salesapp.saleskitservice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductPropertiesModel {
    private Integer id;
    private String shortContent;
    private String longContent;
    private String propName;


}
