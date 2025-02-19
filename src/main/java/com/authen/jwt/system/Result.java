package com.authen.jwt.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private boolean flag;
    private Integer code; // Status code. e.g., 200
    private String message;
    private Object data;
}
