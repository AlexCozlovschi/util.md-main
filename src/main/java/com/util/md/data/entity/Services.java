package com.util.md.data.entity;

import com.util.md.data.Role;
import com.util.md.data.ServiceStatus;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Services {
    private long id;
    private String name;
    private int price;
    private String description;
    private Set<ServiceStatus> status;
    private Categories categoriesByCategoryId;

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
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "status", nullable = true)
    @ElementCollection(fetch = FetchType.EAGER)
    public Set<ServiceStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<ServiceStatus> status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services services = (Services) o;
        return id == services.id && price == services.price && Objects.equals(name, services.name) && Objects.equals(description, services.description) && Objects.equals(status, services.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, status);
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    public Categories getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Categories categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }
}
