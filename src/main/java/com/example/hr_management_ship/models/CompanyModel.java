package com.example.hr_management_ship.models;

import com.example.hr_management_ship.models.enumes.CompanySize;
import com.example.hr_management_ship.models.enumes.Role;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "company")
@Data
public class CompanyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password", nullable = false, length = 1000)
    private String password;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phone_number;
    @Column(name = "company_size")
    @Enumerated(EnumType.STRING)
    private CompanySize companySize;
    @Column(name = "date_of_create")
    private LocalDateTime dateOfCreate;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image logo;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "company")
    private List<UserModel> users = new ArrayList<>();
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @PrePersist
    private void init() {
        dateOfCreate = LocalDateTime.now();
    }

    public List<UserModel> getAllUsers() {
        return users;
    }

}
