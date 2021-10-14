package com.util.md.data.entity;

import com.util.md.data.TaskStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
public class Tasks {
    private long id;
    private Timestamp time;
    private Set<TaskStatus> status;
    private Services servicesByServiceId;

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
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "status", nullable = false)
    public Set<TaskStatus> getStatus() {
        return status;
    }

    public void setStatus(Set<TaskStatus> status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return id == tasks.id && Objects.equals(time, tasks.time) && Objects.equals(status, tasks.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, status);
    }

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id", nullable = false)
    public Services getServicesByServiceId() {
        return servicesByServiceId;
    }

    public void setServicesByServiceId(Services servicesByServiceId) {
        this.servicesByServiceId = servicesByServiceId;
    }
}
