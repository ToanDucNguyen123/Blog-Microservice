package com.example.danhgia.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "danh_gia")
@EntityListeners(AuditingEntityListener.class)
public class DanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String noiDung;

    private int idBaiViet;

    private String tenNguoiViet;

//    @CreatedDate
    private LocalDateTime thoiGian;
}
