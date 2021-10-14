package com.util.md.data.entity;

import com.util.md.data.Role;
import com.util.md.data.UserStatus;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Users {
    private long id;
    private String email;
    private String password;
    private Set<Role> role;
    private Set<UserStatus> status;
    private String name;
    private String surename;
    private Date birthDate;
    private Data dataByDataId;
    private Addresses addressesByAddressId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "birth_date", nullable = false)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role", nullable = false)
    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "status", nullable = true)
    public Set<UserStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<UserStatus> status) {
        this.status = status;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surename", nullable = false, length = 20)
    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Objects.equals(email, users.email) && Objects.equals(password, users.password) && Objects.equals(role, users.role) && Objects.equals(status, users.status) && Objects.equals(name, users.name) && Objects.equals(surename, users.surename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, birthDate, password, role, status, name, surename);
    }

    @ManyToOne
    @JoinColumn(name = "data_id", referencedColumnName = "id", nullable = false)
    public Data getDataByDataId() {
        return dataByDataId;
    }

    public void setDataByDataId(Data dataByDataId) {
        this.dataByDataId = dataByDataId;
    }

//    @ManyToOne
//    @JoinColumn(name = "addresses_id", referencedColumnName = "id", nullable = false)
//    public Addresses getAddressesByAddressId(){
//        return addressesByAddressId;
//
//    }
//
//    public void setAddressesByAddressId(Addresses addressesByAddressId) {
//        this.addressesByAddressId = addressesByAddressId;
//    }
}
