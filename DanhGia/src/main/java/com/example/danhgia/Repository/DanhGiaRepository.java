package com.example.danhgia.Repository;

import com.example.danhgia.Entity.DanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGia,Integer> {
    List<DanhGia> findAllByIdBaiViet (int idBaiViet);


}
