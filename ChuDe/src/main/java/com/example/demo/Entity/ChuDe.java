package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chu_de")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuDe {
    @Id
    private int id;

    private String ten;

    private int trangThai;

    private String moTa;
}
