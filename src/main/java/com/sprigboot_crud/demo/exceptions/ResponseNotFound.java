package com.sprigboot_crud.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseNotFound extends RuntimeException{

    private static Long uniqueId = 1L;
    private String resourceName;
    private String fieldName;
    private Object fieldValue;


    public ResponseNotFound( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s %s %s", resourceName, fieldName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }
}
