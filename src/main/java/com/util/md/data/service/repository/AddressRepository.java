package com.util.md.data.service.repository;

import com.util.md.data.entity.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Addresses, Integer> {
}
