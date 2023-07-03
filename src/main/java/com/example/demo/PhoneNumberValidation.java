package com.example.demo;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

public class PhoneNumberValidation {

    public static boolean validatePhoneNumber(String phoneNumber) {
        boolean isValid = false;
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            PhoneNumber number = phoneNumberUtil.parse(phoneNumber, "");
            isValid = phoneNumberUtil.isValidNumber(number);
        } catch (NumberParseException e) {
            // Handle parsing errors
            System.err.println("NumberParseException was thrown: " + e.toString());
        }
        return isValid;
    }

    public static void main(String[] args) {
        String phoneNumber = "+1 650-253-0000";
        boolean isValid = validatePhoneNumber(phoneNumber);
        if (isValid) {
            System.out.println("Phone number " + phoneNumber + " is valid.");
        } else {
            System.out.println("Phone number " + phoneNumber + " is invalid.");
        }
    }
}
