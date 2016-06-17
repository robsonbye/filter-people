package com.project.guest.converter;

import com.project.guest.domains.Gender;
import com.project.guest.domains.Guest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by robson.andrade on 16/06/2016.
 */
@Slf4j
@Component
public class ConvertFileToGuest {

    public Collection<Guest> convert(final String filePath){
        List<Guest> guests = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                List<String> lineSplited = new ArrayList<String>(Arrays.asList(line.split("\\t")));
                Guest guest = new Guest();
                Iterator<String> lineIterator = lineSplited.iterator();
                guest.setId(Integer.parseInt(lineIterator.next()));
                guest.setFullName(lineIterator.next());
                guest.setHeight(Float.parseFloat(lineIterator.next()));
                guest.setGender(Gender.findGender(lineIterator.next()));
                guest.setAge(lineIterator.next());
                guest.setNeighborhood(lineIterator.next());
                guest.setCity(lineIterator.next());
                guest.setCongregation(lineIterator.next());
                guest.setChapel(lineIterator.next());
                guest.setNickName(lineIterator.next());
                guests.add(guest);
            }

        } catch (IOException e) {
            log.error("Error to try open file",e);
        }
        return guests;

    }
}
