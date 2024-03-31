package com.example.danhgia.FeignClient;

import com.example.danhgia.Response.bai_viet.BaiVietResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "baiviet-service", path = "/bai-viet/api")
public interface BaiVietFiegn {

    @GetMapping("/find-all")
    Page<BaiVietResponse> findAll ();

    @GetMapping("/find-by/{id}")
    BaiVietResponse findById (@PathVariable("id") int id);
}
