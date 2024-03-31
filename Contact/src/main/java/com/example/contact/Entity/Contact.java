package com.example.contact.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lien_he")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    private int id;

    private String ten;

    private String tieuDe;

    private String noiDung;

    private String email;

    private int trangThai;
}
