package com.example.hr_management_ship.models.enumes;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, SUPER_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
