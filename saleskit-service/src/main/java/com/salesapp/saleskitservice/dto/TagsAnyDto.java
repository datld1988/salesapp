package com.salesapp.saleskitservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagsAnyDto {
    private Integer idTag;
    private String idAny;
    private String typeAny;
    private String tagValue;

    public TagsAnyDto(Integer idTag, String idAny, String typeAny) {
        this.idTag = idTag;
        this.idAny = idAny;
        this.typeAny = typeAny;
    }
}
