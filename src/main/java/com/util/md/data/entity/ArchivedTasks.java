package com.util.md.data.entity;

import com.util.md.data.ServiceStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "archived_tasks", schema = "util.md.dev")
public class ArchivedTasks {
    private long id;
    private String userName;
    private String masterName;
    private Timestamp time;
    private String serviceName;
    private String serviceDescription;
    private int servicePrice;
    private Set<ServiceStatus> status;

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
    @Column(name = "user_name", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "master_name", nullable = false, length = 50)
    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "service_name", nullable = false, length = 50)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "service_description", nullable = false, length = 50)
    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    @Basic
    @Column(name = "service_price", nullable = false)
    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "status", nullable = false)
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
        ArchivedTasks that = (ArchivedTasks) o;
        return id == that.id && servicePrice == that.servicePrice && Objects.equals(userName, that.userName) && Objects.equals(masterName, that.masterName) && Objects.equals(time, that.time) && Objects.equals(serviceName, that.serviceName) && Objects.equals(serviceDescription, that.serviceDescription) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, masterName, time, serviceName, serviceDescription, servicePrice, status);
    }
}
