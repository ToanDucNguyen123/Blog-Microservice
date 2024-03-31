package com.example.demo.FeignClient;

import com.example.demo.Response.ChuDeResponse;
import com.example.demo.Response.DanhGiaResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "chude-service", path = "/chu-de/api")
public interface ChuDeFeign {

    @GetMapping("/find-all")
    Page<ChuDeResponse> findAllChuDe ();

    @GetMapping("/find-by/{id}")
    ChuDeResponse findById (@PathVariable("id") int id);

}
