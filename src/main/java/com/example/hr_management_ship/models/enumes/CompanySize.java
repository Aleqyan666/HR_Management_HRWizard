package com.example.hr_management_ship.models.enumes;

import org.springframework.security.core.GrantedAuthority;

public enum CompanySize implements GrantedAuthority {
    SMALL(1, 50),
    MEDIUM(51, 100),
    LARGE(101, Integer.MAX_VALUE);

    private final int minEmployees;
    private final int maxEmployees;

    CompanySize(int minEmployees, int maxEmployees) {
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
    }

    public int getMinEmployees() {
        return minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
