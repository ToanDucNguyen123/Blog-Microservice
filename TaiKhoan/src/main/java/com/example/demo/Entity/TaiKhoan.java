package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tai_khoan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoan {
    @Id
    private int id;

    private String username;

    private String password;

    private String hoTen;

    private String quyen;

    private int trangThai;
}
