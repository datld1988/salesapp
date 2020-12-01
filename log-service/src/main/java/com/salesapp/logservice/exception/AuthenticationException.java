package com.salesapp.logservice.exception;

import com.salesapp.common.dto.Message;
import com.salesapp.common.utils.ErrorCode;
import org.zalando.problem.AbstractThrowableProblem;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationException extends AbstractThrowableProblem {
    private static final long serialVersionUID = 1;

    private Message message;

    public AuthenticationException(Message message){
        this.message = message;
    }

    public AuthenticationException(){
        this.message = new Message(ErrorCode.AUTHENTICATION, "User Name or Password is not correct");
    }

    private static Map<String, Object> getAlertParameters(String entityName, String errorKey) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("message", "error." + errorKey);
        parameters.put("params", entityName);
        return parameters;
    }

    public Message getMessages() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public static class InvalidPasswordException extends RuntimeException {

        private static final long serialVersionUID = 1;

        public InvalidPasswordException() {
            super("Incorrect password");
        }

    }
}
