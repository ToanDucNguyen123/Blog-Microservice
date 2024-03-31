package com.example.demo.Response;

import com.example.demo.Response.bai_viet.BaiVietResponse;
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

}
