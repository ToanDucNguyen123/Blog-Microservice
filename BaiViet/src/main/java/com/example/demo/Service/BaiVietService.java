package com.example.demo.Service;

import com.example.demo.Entity.BaiViet;
import com.example.demo.FeignClient.ChuDeFeign;
import com.example.demo.FeignClient.DanhGiaFeign;
import com.example.demo.FeignClient.TaiKhoanFeign;
import com.example.demo.Repository.BaiVietRepository;
import com.example.demo.Response.DanhGiaResponse;
import com.example.demo.Response.bai_viet.BaiVietRequest;
import com.example.demo.Response.bai_viet.BaiVietResponse;
import com.example.demo.Response.ChuDeResponse;
import com.example.demo.Response.TaiKhoanResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class BaiVietService {
    @Autowired
    BaiVietRepository baiVietRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ChuDeFeign chuDeFeign;

    @Autowired
    DanhGiaFeign danhGiaFeign;

    @Autowired
    TaiKhoanFeign taiKhoanFeign;

    public List<BaiVietResponse> findTop2NhieuDanhGia () {
        List<Integer> listIdBaiViet = baiVietRepository.findAllIdBaiViet();
        List<DanhGiaResponse> danhGiaResponseList;
        List<DanhGiaSort> danhGiaSortList = new ArrayList<>();
        for (Integer id: listIdBaiViet) {
            danhGiaResponseList = danhGiaFeign.findAllByIdBaiViet(id);
            danhGiaSortList.add(new DanhGiaSort(id,danhGiaResponseList.size()));
        }
        danhGiaSortList.sort((o1, o2) -> o2.getSoLuong() - o1.getSoLuong());
        List<BaiViet> baiVietList = baiVietRepository.findByIdOrId(danhGiaSortList.get(0).getId(), danhGiaSortList.get(1).getId());
        List<BaiVietResponse> listBaiVietResponse = Arrays.asList(modelMapper.map(baiVietList,BaiVietResponse[].class));
        List<TaiKhoanResponse> listTaiKhoanResponse = taiKhoanFeign.findAllTaiKhoan().getContent();
        List<ChuDeResponse> listChuDeResponse = chuDeFeign.findAllChuDe().getContent();
        listBaiVietResponse.forEach(bvrp -> {
            baiVietList.forEach(bv -> {
                if (bv.getId() == bvrp.getId()){
                    listTaiKhoanResponse.forEach(tk -> {
                        if (tk.getId()==bv.getNguoiDang()) {
                            bvrp.setNguoiDang(tk);
                        }
                    });
                    listChuDeResponse.forEach(cd -> {
                        if (cd.getId()==bv.getIdChuDe()) {
                            bvrp.setChuDe(cd);
                        }
                    });
                }
            });
        });
        return listBaiVietResponse;
    }

    public List<BaiVietResponse> findByIdChuDe (int idChuDe) {
        List<BaiViet> listBaiViet = baiVietRepository.findBaiVietByIdChuDe(idChuDe);
        List<BaiVietResponse> listBaiVietResponse = Arrays.asList(modelMapper.map(listBaiViet,BaiVietResponse[].class));
        List<TaiKhoanResponse> listTaiKhoanResponse = taiKhoanFeign.findAllTaiKhoan().getContent();
        List<ChuDeResponse> listChuDeResponse = chuDeFeign.findAllChuDe().getContent();
        listBaiVietResponse.forEach(bvrp -> {
            listBaiViet.forEach(bv -> {
                if (bv.getId() == bvrp.getId()){
                    listTaiKhoanResponse.forEach(tk -> {
                        if (tk.getId()==bv.getNguoiDang()) {
                            bvrp.setNguoiDang(tk);
                        }
                    });
                    listChuDeResponse.forEach(cd -> {
                        if (cd.getId()==bv.getIdChuDe()) {
                            bvrp.setChuDe(cd);
                        }
                    });
                }
            });
        });
        return listBaiVietResponse;
    }

    public List<BaiVietResponse> findTop3MoiNhat () {
        List<BaiViet> listBaiViet = baiVietRepository.findTop3ByOrderByNgayDangDesc();
        List<BaiVietResponse> listBaiVietResponse = Arrays.asList(modelMapper.map(listBaiViet,BaiVietResponse[].class));
        List<TaiKhoanResponse> listTaiKhoanResponse = taiKhoanFeign.findAllTaiKhoan().getContent();
        List<ChuDeResponse> listChuDeResponse = chuDeFeign.findAllChuDe().getContent();
        listBaiVietResponse.forEach(bvrp -> {
            listBaiViet.forEach(bv -> {
                if (bv.getId() == bvrp.getId()){
                    listTaiKhoanResponse.forEach(tk -> {
                        if (tk.getId()==bv.getNguoiDang()) {
                            bvrp.setNguoiDang(tk);
                        }
                    });
                    listChuDeResponse.forEach(cd -> {
                        if (cd.getId()==bv.getIdChuDe()) {
                            bvrp.setChuDe(cd);
                        }
                    });
                }
            });
        });
        return listBaiVietResponse;
    }

    public Page<BaiVietResponse> findAllExceptDeleted (int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,5);
        Page<BaiViet> pageData = baiVietRepository.findAllByTrangThaiOrTrangThai(baiVietRepository.ACTIVE,baiVietRepository.DISABLED,pageable);
        Page<BaiVietResponse> pageDataResponse = pageData.map(BaiVietResponse::convertToResponse);
        List<TaiKhoanResponse> listTaiKhoanResponse = taiKhoanFeign.findAllTaiKhoan().getContent();
        List<ChuDeResponse> listChuDeResponse = chuDeFeign.findAllChuDe().getContent();
        pageDataResponse.getContent().forEach(bvrp -> {
            pageData.getContent().forEach(bv -> {
                if (bv.getId() == bvrp.getId()){
                    listTaiKhoanResponse.forEach(tk -> {
                        if (tk.getId()==bv.getNguoiDang()) {
                            bvrp.setNguoiDang(tk);
                        }
                    });
                    listChuDeResponse.forEach(cd -> {
                        if (cd.getId()==bv.getIdChuDe()) {
                            bvrp.setChuDe(cd);
                        }
                    });
                }
            });
        });
        return pageDataResponse;
    }

    public BaiVietResponse findById (int id) {
        BaiViet baiViet = baiVietRepository.findById(id).orElse(null);
        if (baiViet==null){
            return new BaiVietResponse();
        }else {
            BaiVietResponse response = modelMapper.map(baiViet,BaiVietResponse.class);
            ChuDeResponse chuDeResponse = chuDeFeign.findById(baiViet.getIdChuDe());
            TaiKhoanResponse taiKhoanResponse = taiKhoanFeign.findById(baiViet.getNguoiDang());
            response.setChuDe(chuDeResponse);
            response.setNguoiDang(taiKhoanResponse);
            return response;
        }
    }

    public BaiVietResponse findARanDom () {
        BaiViet baiViet = baiVietRepository.findARanDomBaiViet();
            BaiVietResponse response = modelMapper.map(baiViet,BaiVietResponse.class);
            ChuDeResponse chuDeResponse = chuDeFeign.findById(baiViet.getIdChuDe());
            TaiKhoanResponse taiKhoanResponse = taiKhoanFeign.findById(baiViet.getNguoiDang());
            response.setChuDe(chuDeResponse);
            response.setNguoiDang(taiKhoanResponse);
            return response;

    }

    public BaiVietResponse save (BaiVietRequest request) {
        try {
            BaiViet baiViet = baiVietRepository.save(modelMapper.map(request,BaiViet.class));
            if (baiViet == null) {
                return new BaiVietResponse();
            }else {
                BaiVietResponse response = modelMapper.map(baiViet,BaiVietResponse.class);
                ChuDeResponse chuDeResponse = chuDeFeign.findById(request.getIdChuDe());
                TaiKhoanResponse taiKhoanResponse = taiKhoanFeign.findById(request.getNguoiDang());
                response.setChuDe(chuDeResponse);
                response.setNguoiDang(taiKhoanResponse);
                return response;
            }
        }catch (Exception e){
            e.printStackTrace();
            return new BaiVietResponse();
        }
    }

    public BaiVietResponse update (BaiVietRequest request) {
        try {
            BaiViet baiViet = baiVietRepository.save(modelMapper.map(request,BaiViet.class));
            if (baiViet == null) {
                return new BaiVietResponse();
            }else {
                BaiVietResponse response = modelMapper.map(baiViet,BaiVietResponse.class);
                ChuDeResponse chuDeResponse = chuDeFeign.findById(request.getIdChuDe());
                TaiKhoanResponse taiKhoanResponse = taiKhoanFeign.findById(request.getNguoiDang());
                response.setChuDe(chuDeResponse);
                response.setNguoiDang(taiKhoanResponse);
                return response;
            }
        }catch (Exception e){
            e.printStackTrace();
            return new BaiVietResponse();
        }
    }

    public boolean delete (int id ){
        try {
            BaiViet baiViet = baiVietRepository.findById(id).orElse(null);
            if (baiViet==null){
                return false;
            }else {
                baiViet.setTrangThai(BaiVietRepository.DELETED);
                baiVietRepository.save(baiViet);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
