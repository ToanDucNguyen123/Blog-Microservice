package com.example.danhgia.Service;

import com.example.danhgia.Entity.DanhGia;
import com.example.danhgia.FeignClient.BaiVietFiegn;
import com.example.danhgia.Repository.DanhGiaRepository;
import com.example.danhgia.Response.danh_gia.DanhGiaResponse;
import com.example.danhgia.Response.danh_gia.DanhGiaResquest;
import com.example.danhgia.Response.bai_viet.BaiVietResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DanhGiaService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DanhGiaRepository danhGiaRepository;
    @Autowired
    BaiVietFiegn baiVietFiegn;

    public Page<DanhGiaResponse> findAll (int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,5);
        Page<DanhGia> pageData = danhGiaRepository.findAll(pageable);
        Page<DanhGiaResponse> pageDataResponse = pageData.map(DanhGiaResponse::convertToResponse);
        List<BaiVietResponse> listBaiVietResponse = baiVietFiegn.findAll().getContent();
        pageData.getContent().forEach(dg -> {
            pageDataResponse.getContent().forEach(dgrp ->{
                if (dg.getId()==dgrp.getId()){
                    listBaiVietResponse.forEach(bv -> {
                        if (bv.getId() == dg.getIdBaiViet()) {
                            dgrp.setBaiViet(bv);
                        }
                    });
                }
            });
        });
        return pageDataResponse;
    }

    public List<DanhGiaResponse> findAllByIdBaiViet (int idBaiViet){
        List<DanhGia> listDanhGia = danhGiaRepository.findAllByIdBaiViet(idBaiViet);
        List<DanhGiaResponse>  listDanhGiaResponse = Arrays.asList(modelMapper.map(listDanhGia,DanhGiaResponse[].class));
        List<BaiVietResponse> listBaiVietResponse = baiVietFiegn.findAll().getContent();
        listDanhGia.forEach(dg -> {
            listDanhGiaResponse.forEach(dgrp ->{
                if (dg.getId()==dgrp.getId()){
                    listBaiVietResponse.forEach(bv -> {
                        if (bv.getId() == dg.getIdBaiViet()) {
                            dgrp.setBaiViet(bv);
                        }
                    });
                }
            });
        });
        return listDanhGiaResponse;
    }

    public DanhGiaResponse save (DanhGiaResquest request) {
        try {
            DanhGia danhGia = danhGiaRepository.save(modelMapper.map(request,DanhGia.class));
            DanhGiaResponse response = modelMapper.map(danhGia,DanhGiaResponse.class);
            response.setBaiViet(baiVietFiegn.findById(danhGia.getIdBaiViet()));
            return response;
        }catch (Exception e){
            e.printStackTrace();
            return new DanhGiaResponse();
        }
    }

}
