package com.example.demo.Response;

import com.example.demo.Entity.ChuDe;
import com.example.demo.Service.ChuDeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuDeResponse {

    private int id;

    private String ten;

    private int trangThai;

    private String moTa;


    public static ChuDeResponse convertToResponse(ChuDe chuDe) {
        ChuDeResponse response = new ModelMapper().map(chuDe,ChuDeResponse.class);
        return response;
    }
}
