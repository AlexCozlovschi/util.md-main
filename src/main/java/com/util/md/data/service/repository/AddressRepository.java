package com.util.md.data.service.repository;

import com.util.md.data.entity.Addresses;
import com.util.md.data.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Addresses, Integer> {
    List<Addresses> findAllByLocation(String loc );
}
