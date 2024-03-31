package com.example.danhgia.Response.bai_viet;

import com.example.danhgia.Response.ChuDeResponse;
import com.example.danhgia.Response.TaiKhoanResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiVietResponse {

    private int id;

    private String tieuDe;

    private String noiDung;

    private ChuDeResponse chuDe;

    private int trangThai;

    private LocalDateTime ngayDang;

    private TaiKhoanResponse nguoiDang;

    private String thumbnail;

    private String gioiThieu;

}
