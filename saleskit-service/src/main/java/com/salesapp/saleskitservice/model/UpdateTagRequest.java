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
public class UpdateTagRequest {

    @NotNull(message = "Tag id is not null")
    private Integer tagId;

    @NotNull(message = "Tag Value is not null")
    @NotEmpty(message = "Tag Value is not empty")
    private String tagValue;

    @NotNull(message = "Tag type is not null")
    private List<String> tagType;

    @NotNull(message = "Tag type is not null")
    private List<String> assignee;
}
