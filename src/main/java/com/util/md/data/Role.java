package com.util.md.data;

public enum Role {
    USER("USER"), ADMIN("ADMIN"), MASTER("MASTER");

    private String roleName;

    private Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
