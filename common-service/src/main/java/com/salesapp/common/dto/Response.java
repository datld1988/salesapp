package com.uniform.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.uniform.common.utils.ErrorCode;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 1. Sử dụng kiểu trả về là Response<E>
 * @param <E>
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response<E> {
    private Message message;
    private List<E> data;

//    private PageDTO.Response page;

    public static Response error(String code, String message) {
        Response response = new Response();
        Message m = new Message(code, message);
        response.setMessage(m);
        return response;
    }

    public static Response success(String message) {
        Response response = new Response();
        Message m = new Message(ErrorCode.OK, message);
        response.setMessage(m);
        return response;
    }

    public static Response success(List data) {
        Response response = new Response();
        Message m = new Message(ErrorCode.OK);
        response.setMessage(m);
        response.setData(data);
        return response;
    }

    public static Response success(Object data) {
        Response response = new Response();
        Message m = new Message(ErrorCode.OK);
        response.setMessage(m);
        response.setData(Collections.singletonList(data));
        return response;
    }

//    public Response(List<E> data, PageDTO.Response page) {
//        this.data = data;
//        this.page = page;
//    }

}


///**
// * 2. Sử dụng cho kiểu trả về là ResponseEntity<Response<UserDto>>
// * @param <E>
// */
//@Data
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
//public class Response<E> {
//    private Message message;
//    private List<E> data;
//
////    private PageDTO.Response page;
//
//
////    public void error(String code, String message) {
////        Message m = new Message(code, message);
////        this.setMessage(m);
////    }
////
////    public void success(String message) {
////        Message m = new Message(ErrorCode.OK, message);
////        this.setMessage(m);
////    }
////
////    public void success(List<E> data) {
////        Message m = new Message(ErrorCode.OK);
////        this.setMessage(m);
////        this.setData(data);
////    }
////
////    public void success(E data) {
////        Message m = new Message(ErrorCode.OK);
////        this.setMessage(m);
////        this.setData(Collections.singletonList(data));
////    }
//
////    public Response(List<E> data, PageDTO.Response page) {
////        this.data = data;
////        this.page = page;
////    }
//
//}
