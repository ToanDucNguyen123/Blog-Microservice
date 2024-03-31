package com.example.demo.Controller;

import com.example.demo.Response.ChuDeRequest;
import com.example.demo.Response.ChuDeResponse;
import com.example.demo.Service.ChuDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chu-de/api")
public class ChuDeController {

    @Autowired
    ChuDeService chuDeService;

    @GetMapping("/find-all")
    public ResponseEntity<Page<ChuDeResponse>> findAll (@RequestParam Optional<Integer> pageNumber) {
        Page<ChuDeResponse> pageData = chuDeService.findAllChuDeExceptDeleted(pageNumber.orElse(0));
        return ResponseEntity
                .ok(pageData);
    }

    @GetMapping("/find-all-active")
    public ResponseEntity<List<ChuDeResponse>> findAllActive () {
        List<ChuDeResponse> list = chuDeService.findAllActive();
        return ResponseEntity
                .ok(list);
    }

    @GetMapping("/find-by/{id}")
    public ResponseEntity<ChuDeResponse> findAll (@PathVariable("id") int id) {
        ChuDeResponse response = chuDeService.findById(id);
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


    @PostMapping("/save")
    public ResponseEntity<ChuDeResponse> save (@RequestBody ChuDeRequest request) {
        ChuDeResponse response = chuDeService.save(request);
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

    @PutMapping("/update")
    public ResponseEntity<ChuDeResponse> update (@RequestBody ChuDeRequest request) {
        ChuDeResponse response = chuDeService.save(request);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> update (@PathVariable("id") int id) {
        if (chuDeService.delete(id) == false) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK).build();
        }
    }
}
