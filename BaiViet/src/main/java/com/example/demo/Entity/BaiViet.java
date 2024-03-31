package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "bai_viet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaiViet {
    @Id
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
