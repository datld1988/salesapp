package com.uniform.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response<E> {
    private Message message;
    private List<E> data;

//    private PageDTO.Response page;

    public Response() {
    }

    public Response(Message message, List<E> data) {
        this.message = message;
        this.data = data;
    }

//    public Response(List<E> data, PageDTO.Response page) {
//        this.data = data;
//        this.page = page;
//    }

    public Response(List<E> data) {
        this.data = data;
    }
}
