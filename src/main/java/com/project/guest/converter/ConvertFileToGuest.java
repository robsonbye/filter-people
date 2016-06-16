package com.project.guest.converter;

import com.project.guest.domains.Gender;
import com.project.guest.domains.Guest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by robson.andrade on 16/06/2016.
 */
@Slf4j
@Component
public class ConvertFileToGuest {

    public Collection<Guest> convert(String filePath){
        List<Guest> guests = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] lineSplited = line.split("\\t");
                Guest guest = new Guest();
                guest.setId(Integer.parseInt(lineSplited[0]));
                guest.setFullName(lineSplited[1]);
                guest.setHeight(Float.parseFloat(lineSplited[2]));
                guest.setGender(Gender.findGender(lineSplited[3]));
                guest.setAge(lineSplited[4]);
                guest.setNeighborhood(lineSplited[5]);
                guest.setCity(lineSplited[6]);
                guest.setCongregation(lineSplited[7]);
                guest.setChapel(lineSplited[8]);
                guest.setNickName(lineSplited[9]);
                guests.add(guest);
            }

        } catch (IOException e) {
            log.error("Error to try open file",e);
        }
        return guests;

    }
}
