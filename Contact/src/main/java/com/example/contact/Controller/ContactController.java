package com.example.contact.Controller;

import com.example.contact.Response.ContactRequest;
import com.example.contact.Response.ContactResponse;
import com.example.contact.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact/api")
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("/find-all")
    public ResponseEntity<Page<ContactResponse>> findAll(@RequestParam Optional<Integer> pageNumber){
        Page<ContactResponse> pageData = contactService.findAll(pageNumber.orElse(0));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pageData);
    }

    @PostMapping("/save")
    public ResponseEntity<ContactResponse> findAll(@RequestBody ContactRequest request){
        ContactResponse response = contactService.save(request);
        if (response == null) {
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
    public ResponseEntity<Void> delete(@PathVariable("id") int id){
        if (contactService.delete(id)==false) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        }
    }

}
