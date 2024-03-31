package com.example.contact.Repository;

import com.example.contact.Entity.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    public static final int ACTIVE = 1;
    public static final int DELETED = 2;
    Page<Contact> findAllByTrangThai (int active, Pageable pageable);
}
