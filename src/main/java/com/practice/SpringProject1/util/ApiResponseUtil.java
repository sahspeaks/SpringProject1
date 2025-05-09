package com.practice.SpringProject1.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtil {

    public static <T> ResponseEntity<ApiResponse<T>> buildResponse(ApiResponse<T> response) {
        HttpStatus status = getStatus(response);
        return new ResponseEntity<>(response, status);
    }

    private static <T> HttpStatus getStatus(ApiResponse<T> response) {
        if (response.isSuccess()) {
            return HttpStatus.OK;
        } else {
            String message = response.getMessage().toLowerCase();
            if (message.contains("not found")) return HttpStatus.NOT_FOUND;
            if (message.contains("unauthorized")) return HttpStatus.UNAUTHORIZED;
            if (message.contains("forbidden")) return HttpStatus.FORBIDDEN;
            if (message.contains("conflict")) return HttpStatus.CONFLICT;
            return HttpStatus.BAD_REQUEST;
        }
    }
}

