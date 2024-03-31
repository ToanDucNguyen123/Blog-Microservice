package com.example.contact.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {

    private String ten;

    private String tieuDe;

    private String noiDung;

    private String email;

    private int trangThai;
}
