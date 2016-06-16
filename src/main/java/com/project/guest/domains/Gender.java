package com.project.guest.domains;

/**
 * Created by robson.andrade on 16/06/2016.
 */
public enum Gender {
    FAMALE ("Feminino"),
    MALE ("Masculino");

    private String name;

    Gender(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Gender findGender(String name){
        Gender genderResult = null;
        for (Gender gender:Gender.values()) {
            if(gender.getName().equals(name)) {
                genderResult = gender;
                break;
            }
        }
        return genderResult;
    }
}
