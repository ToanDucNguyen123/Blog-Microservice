package com.example.danhgia.Response.danh_gia;

import com.example.danhgia.Entity.DanhGia;
import com.example.danhgia.Response.bai_viet.BaiVietResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DanhGiaResponse {
    private int id;

    private String noiDung;

    private BaiVietResponse baiViet;

    private String tenNguoiViet;

    private LocalDateTime thoiGian;

    public static DanhGiaResponse convertToResponse(DanhGia danhGia) {
        DanhGiaResponse response = new ModelMapper().map(danhGia,DanhGiaResponse.class);
        return response;
    }
}
