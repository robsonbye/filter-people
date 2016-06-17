package com.project.guest.domains;

import lombok.Data;

/**
 * Created by robson.andrade on 15/06/2016.
 */
@Data
public class Guest {
    private Integer id;
    private String fullName;
    private String nickName;
    private Float height;
    private Gender gender;
    private String age;
    //bairro
    private String neighborhood;
    private String city;
    //paróquia
    private String congregation;
    //capela
    private String chapel;
    private Integer chairNumber;

}
