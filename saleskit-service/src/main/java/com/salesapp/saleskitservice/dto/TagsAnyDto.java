package com.salesapp.saleskitservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagsAnyDto {
    private Integer idTag;
    private String valueTag;
    private String idAny;
    private String typeAny;
    private String assignee;

}
