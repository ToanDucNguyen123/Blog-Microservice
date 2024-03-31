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
public class DanhGiaResquest {
    private int id;

    private String noiDung;

    private int idBaiViet;

    private String tenNguoiViet;

    private LocalDateTime thoiGian;

}
