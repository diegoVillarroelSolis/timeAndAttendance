package com.husky.entities;


public enum Gender {
    MALE, FEMALE, UNDEFINED;


    public static Gender setGender(String inputGender){
        Gender gender = Gender.UNDEFINED;
        if (inputGender.equals("MALE")){
            gender=Gender.MALE;
        }
        if (inputGender.equals("FEMALE")){
            gender=Gender.FEMALE;
        }
        return gender;
    }
}

