package com.example.hr_management_ship.services;

import com.example.hr_management_ship.exception.PasswordRuleException;
import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.models.enumes.CoinRating;
import com.example.hr_management_ship.models.enumes.Gender;
import com.example.hr_management_ship.repositorys.UserRepository;
import com.example.hr_management_ship.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
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
        log.info("searchUserByFirstName method called with firstName: " + firstName);
        Validator.checkFirstName(firstName);
        return userRepository.findByFirstName(firstName);
    }

    public List<UserModel> searchUserByLastName(String lastName) {
        log.info("searchUserByLastName method called with lastName: " + lastName);
        Validator.checkLastName(lastName);
        return userRepository.findByLastName(lastName);
    }


    public List<UserModel> searchUserByPosition(String position) {
        log.info("searchUserByPosition method called with position: " + position);
        return userRepository.findByPosition(position);
    }

    public List<UserModel> searchUserByGender(Gender gender) {
        log.info("searchUserByGender method called with firstName: " + gender.toString());
        Validator.checkGender(gender);
        return userRepository.findByGender(gender);
    }

    public Double getUserRating(long id) {
        log.info("getUserRating method called with id: " + id);
        Validator.checkId(id);
        UserModel user = userRepository.getUserModelById(id);
        Validator.checkEntity(user);
        return (double) (user.getTotalCoins() / user.getTotalTransactions());
    }


    public void sendCoin(long id, CoinRating coinRating) {
        log.info("sendCoin method called with id: " + id + ", coinRating: " + coinRating);

        try {
            Validator.checkId(id);
            Validator.checkCoinRating(coinRating);
            UserModel user = userRepository.getUserModelById(id);
            Validator.checkEntity(user);

            user.setTotalCoins(user.getTotalCoins() + coinRating.ordinal() + 1);
            user.setTotalTransactions(user.getTotalTransactions() + 1);
            userRepository.save(user);

            log.info("Coin sent successfully for user with id: " + id);
        } catch (Exception e) {
            log.error("An error occurred while sending the coin", e);
            throw e;
        }
    }

    public void changeDateOfBirth(long id, LocalDateTime dob) {
        log.info("changeDateOfBirth method called with id: " + id + ", date of birth: " + dob);

        try {
            Validator.checkId(id);
            Validator.checkDate(dob.toString());
            UserModel user = userRepository.getUserModelById(id);
            Validator.checkEntity(user);
            user.setDayOfBirth(dob);
            userRepository.save(user);
            log.info("Date of birth changed successfully for user with id: " + id);
        } catch (Exception e) {
            log.error("An error occurred while changing the date of birth", e);
            throw e;
        }
    }

    public UserModel getUserById(long id) {
        log.info("getById method called with id: " + id);

        try {
            Validator.checkId(id);
            UserModel user = userRepository.getUserModelById(id);
            log.info("User retrieved successfully for id: " + id);
            return user;
        } catch (Exception e) {
            log.error("An error occurred while getting the user by id", e);
            throw e;
        }
    }

    public void changeSocialSite(long id, String linkedin) {
        log.info("changeSocialSite method called with id: " + id + ",linkedin link: " + linkedin);

        try {
            Validator.checkId(id);
            Validator.checkLinkedin(linkedin);
            UserModel user = userRepository.getUserModelById(id);
            Validator.checkEntity(user);
            user.setLinkedIn(linkedin);
            userRepository.save(user);
            log.info("User Linkedin link successfully change for : " + linkedin);
        } catch (Exception e) {
            log.error("An error occurred while changing the user linkedin account link by id", e);
            throw e;
        }
    }

    public void selectGender(long id, Gender gender) {
        log.info("selectGender method called with id: " + id + ", gender: " + gender);

        try {
            Validator.checkId(id);
            Validator.checkGender(gender);
            UserModel user = userRepository.getUserModelById(id);
            Validator.checkEntity(user);
            user.setGender(gender);
            userRepository.save(user);
            log.info("Gender selected successfully for user with id: " + id);
        } catch (Exception e) {
            log.error("An error occurred while selecting the gender", e);
            throw e;
        }
    }

    //TODO verification part
    public void changePassword(long id, String newPassword, String repeatNewPassword) {
        log.info("changePassword method called with id: " + id);

        try {
            Validator.checkId(id);
            if (!newPassword.equals(repeatNewPassword)) {
                throw new PasswordRuleException();
            }
            Validator.checkPassword(newPassword);
            UserModel user = userRepository.getUserModelById(id);
            user.setPassword(newPassword);
            userRepository.save(user);
        } catch (Exception e) {
            log.error("An error occurred while changing the password", e);
            throw e;
        }
    }

    public void changePhone(long id, String phone, String password) {
        log.info("changePhone method called with id: " + id + ", phone: " + phone);

        try {
            Validator.checkId(id);
            Validator.checkPhoneNumber(phone);
            UserModel user = userRepository.getUserModelById(id);
            Validator.checkEntity(user);
            if (user.getPassword().equals(password)) {
                user.setPhoneNumber(phone);
            }else throw new PasswordRuleException();
            userRepository.save(user);
            log.info("Phone changed successfully for user with id: " + id);
        } catch (Exception e) {
            log.error("An error occurred while changing the phone", e);
            throw e;
        }
    }

    //TODO
    public void changeEmail(long id, String email) {
        log.info("changeEmail method called with id: " + id + ", email: " + email);

        try {
            Validator.checkId(id);
            Validator.checkEmail(email);
            UserModel user = userRepository.getUserModelById(id);
            Validator.checkEntity(user);
            user.setEmail(email);
            userRepository.save(user);
            log.info("Email changed successfully for user with id: " + id);
        } catch (Exception e) {
            log.error("An error occurred while changing the email", e);
            throw e;
        }
    }

    public List<UserModel> getAll(UserModel user) {
        return user.getCompany().getAllUsers();
    }
}
