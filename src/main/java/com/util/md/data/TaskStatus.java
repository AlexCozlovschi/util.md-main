package com.util.md.data;

public enum TaskStatus {
    COMPLETED("COMPLETED"), PENDING("PENDING"), CANCELED("CANCELED");

    private String status;

    private TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
