package com.example.hr_management_ship.validation;

import com.example.hr_management_ship.exception.*;
import com.example.hr_management_ship.models.enumes.CoinRating;
import com.example.hr_management_ship.models.enumes.EmployeeLevel;
import com.example.hr_management_ship.models.enumes.Gender;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.hr_management_ship.models.enumes.EmployeeLevel.*;


public class Validator {

    /**
     * checks validity of user's first name: can't contain other symbols except letters
     * @param firstName
     * @return true/exception regarding the given parameter
     */
    public static boolean checkFirstName(String firstName) {
        if (firstName.matches("[a-zA-Z]+")) {
            return true;
        } else throw new InvalidNameException();
    }

    /**
     * checks validity of user's last name: can't contain other symbols except letters
     * @param lastName
     * @return true/exception regarding the given parameter
     */
    public static boolean checkLastName(String lastName) {
        if (lastName.matches("[a-zA-Z]+")) {
            return true;
        } else throw new InvalidNameException();
    }

    /**
     * checks validity of user's phone: can't contain other symbols except numbers
     * @param phone
     * @return true/exception regarding the given parameter
     */
    public static boolean checkPhoneNumber(String phone) {
        String pattern = "^[1-9]\\d{9}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }

    /**
     * checks validity of user's email: must contain '@'
     * @param email
     * @return true/exception regarding the given parameter
     */
    public static boolean checkEmail(String email) {
        String patternString = "^[\\w.-]+@[\\w.-]+\\.[\\w]+$";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    /**
     * checks validity of user's date of birth: must have (dd/mm/yyyy) form
     * @param dob
     * @return true/exception regarding the given parameter
     */
    public static boolean checkDate(String dob) {
        if (dob.length() > 10 || dob.length() < 8) {
            throw new DateOfBirthException();
        } else {
            String pattern = "\\d{2}/\\d{2}/\\d{4}";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(dob);
            return matcher.matches();
        }
    }



    /**
     * checks validity of user's expertise level: must have certain value
     * @param employeeLevel
     * @return true/exception regarding the given parameter
     */
    public static boolean checkEmployeeLevel(EmployeeLevel employeeLevel) {
        if (employeeLevel.equals(JUNIOR) ||
                employeeLevel.equals(MIDDLE) ||
                employeeLevel.equals(SENIOR) ||
                employeeLevel.equals(C_LEVEL)) {
            return true;
        } else {
            throw new InvalidEmployeeLevelException();
        }
    }

    /**
     * checks validity of user's coins: must have certain value
     * @param coinRating
     * @return true/exception regarding the given parameter
     */
    public static boolean checkCoinRating(CoinRating coinRating) {
        if (coinRating.equals(CoinRating.VALUE1) || coinRating.equals(CoinRating.VALUE2)
         || coinRating.equals(CoinRating.VALUE3) || coinRating.equals(CoinRating.VALUE4)
         || coinRating.equals(CoinRating.VALUE5) || coinRating.equals(CoinRating.VALUE6)
         || coinRating.equals(CoinRating.VALUE7) || coinRating.equals(CoinRating.VALUE8)
         || coinRating.equals(CoinRating.VALUE9) || coinRating.equals(CoinRating.VALUE10)){
            return true;
        }else{
            throw new InvalidCoinRatingException();
        }
    }

    /**
     * checks validity of user's gender: must either be male or female
     * @param gender
     * @return true/exception regarding the given parameter
     */
    public static boolean checkGender(Gender gender){
        if (gender.equals(Gender.MALE) ||  gender.equals(Gender.FEMALE)){
            return true;
        }else{
            throw new InvalidGenderException();
        }
    }

    /**
     * eliminates possible exceptions: Such as NullPointerException
     * @param entity
     * @param <E>
     */
    public static <E> void checkEntity(E entity) {

        if (entity == null) {
            throw new IllegalArgumentException("Entity does not exist.");
        }
    }

    /**
     * checks validity of user's id
     * @param id
     */
    public static void checkId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Entered ID is incorrect.");
        }
    }

    /**
     * checks whether the given list is empty or not
     * @param listCheck
     * @param <E>
     */
    public static <E> void checkList(List<E> listCheck) {
        if (listCheck.isEmpty()) {
            throw new IllegalArgumentException("Not any entity");
        }
    }


}
