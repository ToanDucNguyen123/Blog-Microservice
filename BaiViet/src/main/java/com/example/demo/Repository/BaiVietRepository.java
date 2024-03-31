package com.example.demo.Repository;

import com.example.demo.Entity.BaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository
public interface BaiVietRepository extends JpaRepository<BaiViet, Integer> {
    public static final int ACTIVE = 1;
    public static final int DISABLED = 0;
    public static final int DELETED = 2;

    Page<BaiViet> findAllByTrangThaiOrTrangThai (int active, int disabled, Pageable pageable) ;

    List<BaiViet> findAllByTrangThaiOrTrangThai (int active, int disabled) ;

    @Query("SELECT bv FROM BaiViet bv WHERE bv.trangThai = 1 ORDER BY RAND() LIMIT 1")
    BaiViet findARanDomBaiViet ();

    List<BaiViet> findTop3ByOrderByNgayDangDesc ();

    List<BaiViet> findBaiVietByIdChuDe(int idChuDe);

    @Query("SELECT bv.id FROM BaiViet bv")
    List<Integer> findAllIdBaiViet ();

    List<BaiViet> findByIdOrId (int id1, int id2);

}
