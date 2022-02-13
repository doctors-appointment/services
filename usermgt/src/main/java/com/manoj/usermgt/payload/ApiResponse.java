package com.manoj.usermgt.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ApiResponse {
	private Boolean success;
    private String message;
    private Object responseData;

    public ApiResponse(Boolean success, String message, Object responseData) {
        this.success = success;
        this.message = message;
        this.responseData = responseData;
    }
}
