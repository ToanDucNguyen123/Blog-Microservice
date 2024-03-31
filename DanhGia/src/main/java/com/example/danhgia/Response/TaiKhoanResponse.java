package com.example.danhgia.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoanResponse {
    private int id;

    private String username;

    private String password;

    private String hoTen;

    private String quyen;

    private int trangThai;
}
