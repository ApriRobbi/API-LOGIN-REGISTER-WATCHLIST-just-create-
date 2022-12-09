package com.invest.investment.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private Integer status;

    private Object data;

    private Object error;

    public ApiResponse(){
        this.status = 200;
        this.data = data;
        this.error = error;
    }
}
