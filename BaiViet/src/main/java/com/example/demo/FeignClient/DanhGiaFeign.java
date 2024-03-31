package com.example.demo.FeignClient;

import com.example.demo.Response.DanhGiaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient(name = "danhgia-service", path = "/danh-gia/api")
public interface DanhGiaFeign {
    @GetMapping("/find-all-by/{idBaiViet}")
    List<DanhGiaResponse> findAllByIdBaiViet (@PathVariable("idBaiViet") int idBaiViet);
}
