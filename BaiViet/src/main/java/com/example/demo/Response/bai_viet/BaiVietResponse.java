package com.example.demo.Response.bai_viet;

import com.example.demo.Entity.BaiViet;
import com.example.demo.Response.ChuDeResponse;
import com.example.demo.Response.TaiKhoanResponse;
import jakarta.persistence.Id;
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

    public static BaiVietResponse convertToResponse(BaiViet baiViet) {
        BaiVietResponse response = new ModelMapper().map(baiViet,BaiVietResponse.class);
        return response;
    }
}
