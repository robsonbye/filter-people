package com.project.guest.converter;

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
        List<Guest> inviteds = new ArrayList<>();
        String content = null;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            for (String line : lines) {
                String[] lineSplited = line.split("\\t");
                Guest invited = new Guest();
                invited.setId(Integer.parseInt(lineSplited[0]));
                invited.setFullName(lineSplited[1]);
                invited.setHeight(Float.parseFloat(lineSplited[2]));
                invited.setGender(lineSplited[3]);
                invited.setAge(lineSplited[4]);
                invited.setNeighborhood(lineSplited[5]);
                invited.setCity(lineSplited[6]);
                invited.setCongregation(lineSplited[7]);
                invited.setChapel(lineSplited[8]);
                invited.setNickName(lineSplited[9]);
                inviteds.add(invited);
            }

        } catch (IOException e) {
            log.error("Error to try open file",e);
        }
        return inviteds;

    }
}
