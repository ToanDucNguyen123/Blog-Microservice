package com.example.demo.Service;

import com.example.demo.Entity.ChuDe;
import com.example.demo.Repository.ChuDeRepository;
import com.example.demo.Response.ChuDeRequest;
import com.example.demo.Response.ChuDeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class ChuDeService {
    @Autowired
    ChuDeRepository chuDeRepository;

    @Autowired
    ModelMapper modelMapper;


    public Page<ChuDeResponse> findAllChuDeExceptDeleted (int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,5);
        Page<ChuDe> pageData = chuDeRepository.findAllByTrangThaiOrTrangThai(chuDeRepository.ACTIVE,chuDeRepository.DISABLED,pageable);
        Page<ChuDeResponse> pageDataResponse = pageData.map(ChuDeResponse::convertToResponse);
        return pageDataResponse;

    }

    public List<ChuDeResponse> findAllActive () {
        List<ChuDe> listChuDe = chuDeRepository.findAllByTrangThai(chuDeRepository.ACTIVE);
        List<ChuDeResponse> list = Arrays.asList(modelMapper.map(listChuDe,ChuDeResponse[].class));
        return list;

    }

    public ChuDeResponse findById ( int id){
        ChuDe chuDe = chuDeRepository.findById(id).orElse(null);
        if (chuDe == null){
            return new ChuDeResponse();
        }else {
            ChuDeResponse response = modelMapper.map(chuDe,ChuDeResponse.class);
            return response;
        }
    }

    public ChuDeResponse save (ChuDeRequest request){
        try {
            ChuDe chuDe = chuDeRepository.save(modelMapper.map(request,ChuDe.class));
            ChuDeResponse response = modelMapper.map(chuDe,ChuDeResponse.class);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return new ChuDeResponse();
        }
    }

    public ChuDeResponse update (ChuDeRequest request){
        try {
            ChuDe chuDe = chuDeRepository.save(modelMapper.map(request,ChuDe.class));
            ChuDeResponse response = modelMapper.map(chuDe,ChuDeResponse.class);
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return new ChuDeResponse();
        }
    }

    public boolean delete (int id){
        ChuDe chuDe = chuDeRepository.findById(id).orElse(null);
        if (chuDe==null){
            return false;
        }else {
            chuDe.setTrangThai(ChuDeRepository.DELETED);
            chuDeRepository.save(chuDe);
            return true;
        }
    }
}

