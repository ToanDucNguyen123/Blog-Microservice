package com.example.demo.FeignClient;

import com.example.demo.Response.ChuDeResponse;
import com.example.demo.Response.TaiKhoanResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "taikhoan-service", path = "/tai-khoan/api")
public interface TaiKhoanFeign {

    @GetMapping("/find-all")
    Page<TaiKhoanResponse> findAllTaiKhoan ();

    @GetMapping("/find-by/{id}")
    TaiKhoanResponse findById (@PathVariable("id") int id);
}
