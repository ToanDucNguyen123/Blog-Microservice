package com.example.demo.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuDeRequest {
    private int id;

    private String ten;

    private int trangThai;

    private String moTa;
}
