package com.vujovic.LibManagement;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ISBNValidator implements ConstraintValidator<ValidISBN, String> {

    @Override
    public void initialize(ValidISBN constraintAnnotation){}

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int sum = 0;
        int digit;
        if (value==null)
            return true;
        else if (value.length() == 10 && value.matches("^\\d{10}$")) {
            int pom=1;
            for (int i = 9; i >= 0; i--) {
                digit = value.charAt(i) - '0';
                sum += digit * (pom++);
            }
            if (sum % 11 == 0)
                return true;
            else
                return false;
        }

        else if (value.length()==10 && value.matches("^\\d{9}X$")){
            int pom=1;
            for (char c: value.toCharArray()) {
                if (Character.isDigit(c)){
                    digit=c-'0';
                    sum+=digit*(pom++);
                }
            }
            if (sum%11==1)
                return true;
            else
                return false;
        }
        else
            return false;
    }

}