package com.example.danhgia.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChuDeResponse {
    private int id;

    private String ten;

    private int trangThai;

    private String moTa;
}
