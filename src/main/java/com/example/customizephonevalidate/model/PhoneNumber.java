package com.example.customizephonevalidate.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Component
//Cách 2
public class PhoneNumber implements Validator {
//    Cách 1
//    @NotEmpty(message = "Số là bắt buộc")
//    @Size(min = 10, max = 11, message = "Số phải nằm trong khoảng từ 10 đến 11 ký tự")
//    @Pattern(regexp = "^0[0-9]*$", message = "Số phải bắt đầu bằng 0")
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {

        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length()>11 || number.length()<10){
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }
    }
}