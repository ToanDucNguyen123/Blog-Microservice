package com.example.demo.Controller;

import com.example.demo.Entity.TaiKhoan;
import com.example.demo.Response.TaiKhoanResponse;
import com.example.demo.Service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tai-khoan/api")
public class TaiKhoanController {
    @Autowired
    TaiKhoanService taiKhoanService;

    @GetMapping("/find-all")
    public ResponseEntity<Page<TaiKhoanResponse>> findAll (@RequestParam Optional<Integer> pageNumber) {
        Page<TaiKhoanResponse> pageData = taiKhoanService.findAllExceptDeleted(pageNumber.orElse(0));
        return ResponseEntity
                .ok(pageData);
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<TaiKhoanResponse> findAll (@PathVariable("id") int id) {
        TaiKhoanResponse response = taiKhoanService.findById(id);
        if (response==null){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
    }
}
