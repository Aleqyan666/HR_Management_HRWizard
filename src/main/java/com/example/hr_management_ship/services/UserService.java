package com.example.hr_management_ship.services;

import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.models.enumes.CoinRating;
import com.example.hr_management_ship.models.enumes.EmployeeLevel;
import com.example.hr_management_ship.models.enumes.Gender;
import com.example.hr_management_ship.repositorys.UserRepository;
import com.example.hr_management_ship.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserModel getUserByPrincipal(Principal principal) {
        if (principal == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        return userRepository.findByEmail(principal.getName());
    }

    public List<UserModel> searchUserByFirstName(String firstName) {
        Validator.checkFirstName(firstName);
        return userRepository.findByFirstName(firstName);
    }

    public List<UserModel> searchUserByLastName(String lastName) {
        Validator.checkLastName(lastName);
        return userRepository.findByLastName(lastName);
    }

//    public List<UserModel> searchUserByEmployeeLevel(EmployeeLevel employeeLevel) {
//        Validator.checkEmployeeLevel(employeeLevel);
//        return userRepository.findByEmployeeLevel(employeeLevel);
//    }

    public List<UserModel> searchUserByPosition(String position) {
        return userRepository.findByPosition(position);
    }

    public List<UserModel> searchUserByGender(Gender gender) {
        Validator.checkGender(gender);
        return userRepository.findByGender(gender);
    }

    //TODO
    public void sendCoin(long id, CoinRating coinRating) {
        log.info("sendCoin method called with id: " + id + ", coinRating: " + coinRating);

        try {
            Validator.checkId(id);
            Validator.checkCoinRating(coinRating);
            UserModel user = userRepository.getUserModelById(id);
            Validator.checkEntity(user);

            //UserModel popoxutyunner piti a8vi vor ashxati, erku hat @Column comment a arac
//            if (user.getTotalCoins() == null) {
//                user.setTotalCoins(0L);
//            }
//            if (user.getTotalTransactions() == null) {
//                user.setTotalTransactions(0L);
//            }
//            if (user.getRating() == null) {
//                user.setRating(0.0);
//            }
//
//            user.setTotalCoins(user.getTotalCoins() + coinRating.ordinal() + 1);
//            user.setTotalTransactions(user.getTotalTransactions() + 1);
//            user.setRating((double) (user.getTotalCoins() / user.getTotalTransactions()));

            userRepository.save(user);

            log.info("Coin sent successfully for user with id: " + id);
        } catch (Exception e) {
            log.error("An error occurred while sending the coin", e);
            throw e;
        }
    }
}
