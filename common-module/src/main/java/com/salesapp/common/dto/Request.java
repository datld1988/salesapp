package com.salesapp.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.Data;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//@Data
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

    public E getRequestData() {
        return requestData;
    }

    public void setRequestData(E requestData) {
        this.requestData = requestData;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    //    @Data
    public static final class Filter {
        private String key;
        private List<Object> values;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }
}

//    @Data
    public static final class Sort {
        private String  sortType;
        private String  sortBy;

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}

}
