package com.sammidev.validator;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
public class PhoneNumberValidator implements Predicate<String> {

    private Predicate<String> isPhoneValid = Pattern.compile("^\\d{12}$").asPredicate();

    @Override
    public boolean test(String phoneNumber) {
        return isPhoneValid.test(phoneNumber) && phoneNumber.startsWith("08");
    }
}