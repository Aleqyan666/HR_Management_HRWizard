package com.example.hr_management_ship.repositorys;

import com.example.hr_management_ship.models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
    CompanyModel findByEmail(String email);
}
