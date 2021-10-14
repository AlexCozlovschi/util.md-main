package com.util.md.data;

public enum UserStatus {
    VERIFIED("VERIFIED"), BLOCKED("BLOCKED"), UNVERIFIED("UNVERIFIED");

    private String status;

    private UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
