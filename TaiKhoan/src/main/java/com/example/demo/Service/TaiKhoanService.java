package com.example.demo.Service;

import com.example.demo.Entity.TaiKhoan;
import com.example.demo.Repository.TaiKhoanRepository;
import com.example.demo.Response.TaiKhoanResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaiKhoanService {

    @Autowired
    TaiKhoanRepository taiKhoanRepository;

    @Autowired
    ModelMapper modelMapper;

    public Page<TaiKhoanResponse> findAllExceptDeleted (int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,5);
        Page<TaiKhoan> pageData = taiKhoanRepository.findAllByTrangThaiOrTrangThai(TaiKhoanRepository.ACTIVE,TaiKhoanRepository.DISABLED,pageable);
        Page<TaiKhoanResponse> pageDataResponse = pageData.map(TaiKhoanResponse::convertToResponse);
        return pageDataResponse;
    }


    public TaiKhoanResponse findById ( int id){
        TaiKhoan taiKhoan = taiKhoanRepository.findById(id).orElse(null);
        if (taiKhoan == null){
            return new TaiKhoanResponse();
        }else {
            TaiKhoanResponse response = modelMapper.map(taiKhoan,TaiKhoanResponse.class);
            return response;
        }

    }
}
