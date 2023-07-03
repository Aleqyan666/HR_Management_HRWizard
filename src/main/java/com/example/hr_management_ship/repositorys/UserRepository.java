package com.example.hr_management_ship.repositorys;

import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.models.enumes.EmployeeLevel;
import com.example.hr_management_ship.models.enumes.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Long> {
    UserModel findByEmail(String email);
    List<UserModel> findByFirstName(String firstName);
    List<UserModel> findByLastName(String lastName);
    List<UserModel> findByEmployeeLevel(EmployeeLevel employeeLevel);
    List<UserModel> findByPosition(String position);
    List<UserModel> findByGender(Gender gender);
    UserModel getUserModelById(Long id);

}
