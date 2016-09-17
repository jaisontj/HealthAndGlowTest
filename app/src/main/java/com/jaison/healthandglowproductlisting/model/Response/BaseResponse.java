package com.jaison.healthandglowproductlisting.model.Response;

/**
 * Created by Jaison on 17/09/16.
 */
public class BaseResponse {
    String status;
    String code;
    String message;

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
