package com.salesapp.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Request<E> {

    // Search conditions
    @Valid
    private E requestData;

    // Sort conditions
    @Valid
    private Sort  sort;
    // Filter conditions
    private List<Filter> filters = new ArrayList<>();

    @Data
    public static final class Filter {
        private String key;
        private List<Object> values;
    }

    @Data
    public static final class Sort {
        private String  sortType;
        private String  sortBy;
    }

}
