package com.salesapp.saleskitservice.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InsertTagRequest {

    @NotNull(message = "Tag Value is not null")
    @NotEmpty(message = "Tag Value is not empty")
    private String tagValue;

    @NotNull(message = "Tag type is not null")
    @NotEmpty(message = "Tag type is not empty")
    private List<String> tagType;

    @NotNull(message = "Tag type is not null")
    @NotEmpty(message = "Tag type is not empty")
    private List<String> assignee;

}
