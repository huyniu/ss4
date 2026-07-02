package com.example.ss4.dto;

public class ApiResponse {
    private String message;
    private boolean status;
    private Object data;

    public ApiResponse(String message, boolean status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data; // Ở bài này, data luôn truyền vào là null
    }

    // Nhớ tạo Getters/Setters nhé
}