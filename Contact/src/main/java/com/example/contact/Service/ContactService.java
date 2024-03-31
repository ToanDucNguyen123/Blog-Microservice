package com.example.contact.Service;

import com.example.contact.Entity.Contact;
import com.example.contact.Repository.ContactRepository;
import com.example.contact.Response.ContactRequest;
import com.example.contact.Response.ContactResponse;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ModelMapper modelMapper;

    public Page<ContactResponse> findAll (int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,5);
        Page<Contact> pageData = contactRepository.findAllByTrangThai(ContactRepository.ACTIVE,pageable);
        Page<ContactResponse> pageDataResponse = pageData.map(ContactResponse::convertToResponse);
        return pageDataResponse;
    }

    public ContactResponse save (ContactRequest request){
        try {
            Contact contact = contactRepository.save(modelMapper.map(request,Contact.class));
            ContactResponse response = modelMapper.map(contact,ContactResponse.class);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return new ContactResponse();
        }
    }

    public boolean delete (int id){
        Contact contact = contactRepository.findById(id).orElse(null);
        if (contact==null) {
            return false;
        }else {
            try {
                contact.setTrangThai(ContactRepository.DELETED);
                contactRepository.save(contact);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }
}
