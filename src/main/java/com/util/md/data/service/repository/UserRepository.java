package com.util.md.data.service.repository;

import com.util.md.data.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import com.util.md.data.Role;
import javax.persistence.Lob;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Users findByEmail(String email);
}