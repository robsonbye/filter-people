package com.project.guest.domains;

import lombok.Data;

/**
 * Created by robson.andrade on 15/06/2016.
 */
@Data
public class Guest {
    Integer id;
    String fullName;
    String nickName;
    Float height;
    String gender;
    String age;
    //bairro
    String neighborhood;
    String city;
    //paróquia
    String congregation;
    //capela
    String chapel;
}
