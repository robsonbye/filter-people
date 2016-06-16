package com.project.guest.usecases;

import com.project.guest.domains.Gender;
import com.project.guest.domains.Guest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robson.andrade on 14/06/2016.
 */
@Service
@Slf4j
public class GuestRules {

    public Collection<Guest> classify(Collection<Guest> guests){
        List<Guest> guestFemale = guests
            .stream()
            .filter(p -> Gender.FAMALE.equals(p.getGender()))
            .sorted((o1, o2) -> o1.getHeight().compareTo(o2.getHeight()))
            .collect(Collectors.toList());

        log.info("Qtde Feminino: {}, {}", guestFemale.size(), guestFemale.toArray());

        List<Guest> guestMale = guests.stream()
            .filter(p -> Gender.MALE.equals(p.getGender()))
            .sorted((o1, o2) -> o1.getHeight().compareTo(o2.getHeight()))
            .collect(Collectors.toList());
        log.info("Qtde Masculino: {}", guestMale.size());

        return null;
    }
}
