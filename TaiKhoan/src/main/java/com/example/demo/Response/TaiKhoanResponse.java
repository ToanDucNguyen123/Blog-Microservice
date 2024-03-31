package com.example.demo.Response;

import com.example.demo.Entity.TaiKhoan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

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

    public static TaiKhoanResponse convertToResponse(TaiKhoan taiKhoan) {
        TaiKhoanResponse response = new ModelMapper().map(taiKhoan,TaiKhoanResponse.class);
        return response;
    }
}
