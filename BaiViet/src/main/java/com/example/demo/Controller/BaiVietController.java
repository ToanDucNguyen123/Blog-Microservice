package com.example.demo.Controller;

import com.example.demo.Response.bai_viet.BaiVietRequest;
import com.example.demo.Response.bai_viet.BaiVietResponse;
import com.example.demo.Service.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bai-viet/api")
public class BaiVietController {
    @Autowired
    BaiVietService baiVietService;

    @GetMapping("/find-top2-nhieu-danh-gia")
    public ResponseEntity<List<BaiVietResponse>> findTop2NhieuDanhGia (){
        List<BaiVietResponse> list = baiVietService.findTop2NhieuDanhGia();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<BaiVietResponse> findAll (@PathVariable("id") int id){
        BaiVietResponse response = baiVietService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/find-a-random")
    public ResponseEntity<BaiVietResponse> findARanDom (){
        BaiVietResponse response = baiVietService.findARanDom();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/find-all")
    public ResponseEntity<Page<BaiVietResponse>> findAll (@RequestParam Optional<Integer> pageNumber){
        Page<BaiVietResponse> pageData = baiVietService.findAllExceptDeleted(pageNumber.orElse(0));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pageData);
    }

    @GetMapping("/find-top3-moi-nhat")
    public ResponseEntity<List<BaiVietResponse>> findTop3MoiNhat (){
        List<BaiVietResponse> list = baiVietService.findTop3MoiNhat();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

    @GetMapping("/find-by-idchude/{idChuDe}")
    public ResponseEntity<List<BaiVietResponse>> findTop3MoiNhat (@PathVariable("idChuDe") int idChuDe){
        List<BaiVietResponse> response = baiVietService.findByIdChuDe(idChuDe);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PostMapping("/save")
    public ResponseEntity<BaiVietResponse> save (@RequestBody BaiVietRequest request){
        BaiVietResponse response = baiVietService.save(request);
        if (response==null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }else {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<BaiVietResponse> update (@RequestBody BaiVietRequest request){
        BaiVietResponse response = baiVietService.save(request);
        if (response==null) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }else {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> update (@PathVariable("id") int id){
        if (baiVietService.delete(id)==false){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).build();
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK).build();
        }
    }
}
