package com.util.md.data.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Data {
    private long id;

    private String picture;
    private Double raiting;
    private String services;
    private String files;

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
    @Column(name = "picture", nullable = true, length = 100)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "raiting", nullable = true, precision = 0)
    public Double getRaiting() {
        return raiting;
    }

    public void setRaiting(Double raiting) {
        this.raiting = raiting;
    }

    @Basic
    @Column(name = "services", nullable = true, length = 50)
    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    @Basic
    @Column(name = "files", nullable = true, length = 100)
    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id &&  Objects.equals(picture, data.picture) && Objects.equals(raiting, data.raiting) && Objects.equals(services, data.services) && Objects.equals(files, data.files);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picture, raiting, services, files);
    }
}
