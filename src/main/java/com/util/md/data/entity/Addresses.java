package com.util.md.data.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Addresses {
    private long id;
    private String location;
    private String name;
    private String details;
    private Users dataByUsersId;

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
    @Column(name = "location", nullable = false, length = 35)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 35)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "details", nullable = true, length = 5)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Addresses addresses = (Addresses) o;
        return id == addresses.id && Objects.equals(location, addresses.location) && Objects.equals(name, addresses.name) && Objects.equals(details, addresses.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, location, name, details);
    }

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    public Users getDataByUsersId() {
        return dataByUsersId;
    }

    public void setDataByUsersId(Users dataByDataId) {
        this.dataByUsersId = dataByDataId;
    }

}