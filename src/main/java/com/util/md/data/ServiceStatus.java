package com.util.md.data;

public enum ServiceStatus {
    ACTIVE("ACTIVE"), INACTIVE("INACTIVE");

    private String status;

    private ServiceStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
