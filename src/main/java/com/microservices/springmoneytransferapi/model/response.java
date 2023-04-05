package com.microservices.springmoneytransferapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class response {
    public static class CustmoErrorResponse {
        private int status;
        private String message;

        public void CustomErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }
    }
}
