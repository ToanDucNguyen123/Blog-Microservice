package com.example.danhgia.Response.bai_viet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiVietRequest {

    private int id;

    private String tieuDe;

    private String noiDung;

    private int idChuDe;

    private int trangThai;

    private LocalDateTime ngayDang;

    private int nguoiDang;

    private String thumbnail;

    private String gioiThieu;
}
