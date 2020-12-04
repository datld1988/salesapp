package com.salesapp.saleskitservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagsDto {
    private Integer id;
    private String value;
    private Integer status;
    public TagsDto(Integer id, String value){
        this.id=id;
        this.value=value;
    }
}
