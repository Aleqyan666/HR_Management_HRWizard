package com.example.hr_management_ship.models;


import com.example.hr_management_ship.models.enumes.EmployeeLevel;
import com.example.hr_management_ship.models.enumes.Gender;
import com.example.hr_management_ship.models.enumes.Role;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "password", nullable = false, length = 1000)
    private String password;
    @Column(name = "dob")
    private LocalDateTime dayOfBirth;
    @Column(name = "social_site")
    private String linkedIn;
    @Column(name = "position")
    private String position;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private EmployeeLevel level;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "doc")
    private LocalDateTime dateOfCreate;
    @Column(name = "active")
    private boolean active;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image avatar;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private CompanyModel company;

//    @Column(name = "total_coins")sranq rating-i hamar en petq + coin uxarkelu
//    private Long totalCoins = 0L;
//    @Column(name = "total_transactions")
//    private Long totalTransactions = 0L;

    @PrePersist
    private void init() {
        dateOfCreate = LocalDateTime.now();
    }

}
