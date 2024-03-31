package com.example.contact.Response;

import com.example.contact.Entity.Contact;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponse {
    private int id;

    private String ten;

    private String tieuDe;

    private String noiDung;

    private String email;

    private int trangThai;

    public static ContactResponse convertToResponse(Contact contact) {
        ContactResponse response = new ModelMapper().map(contact,ContactResponse.class);
        return response;
    }
}
