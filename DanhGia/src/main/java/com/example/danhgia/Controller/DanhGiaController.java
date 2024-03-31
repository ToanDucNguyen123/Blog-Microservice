package com.example.danhgia.Controller;

import com.example.danhgia.Response.danh_gia.DanhGiaResponse;
import com.example.danhgia.Response.danh_gia.DanhGiaResquest;
import com.example.danhgia.Service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/danh-gia/api")
public class DanhGiaController {

    @Autowired
    DanhGiaService danhGiaService;

    @GetMapping("/find-all")
    public ResponseEntity<Page<DanhGiaResponse>> findAll(@RequestParam Optional<Integer> pageNumber){
        Page<DanhGiaResponse> pageData = danhGiaService.findAll(pageNumber.orElse(0));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pageData);
    }

    @GetMapping("/find-all-by/{idBaiViet}")
    public ResponseEntity<List<DanhGiaResponse>> findAllByIdBaiViet (@PathVariable("idBaiViet") int idBaiViet){
        List<DanhGiaResponse> list = danhGiaService.findAllByIdBaiViet(idBaiViet);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }


    @PostMapping("/save")
    public ResponseEntity<DanhGiaResponse> findAllByIdBaiViet (@RequestBody DanhGiaResquest resquest){
        DanhGiaResponse response = danhGiaService.save(resquest);
        if (response==null){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }else {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }
    }
}
