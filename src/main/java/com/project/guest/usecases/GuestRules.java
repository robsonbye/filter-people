package com.project.guest.usecases;

import com.project.guest.domains.Gender;
import com.project.guest.domains.Guest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by robson.andrade on 14/06/2016.
 */
@Service
@Slf4j
public class GuestRules {


    public Collection<Guest> classify(final Collection<Guest> guests){
        LinkedList<Guest> guestOrdered = new LinkedList<>();
        final List<Guest> guestFemale = filterByGender(Gender.FAMALE,guests);
        final List<Guest> guestMale = filterByGender(Gender.MALE,guests);

        final Iterator<Guest> iteratorMale = guestMale.iterator();
        final Iterator<Guest> iteratorFemale = guestFemale.iterator();

        for (int i = 1; i < guestFemale.size()+guestMale.size(); i++){
            if(iteratorFemale.hasNext()){
                guestOrdered.add(iteratorFemale.next());
            }
            if(iteratorMale.hasNext()){
                guestOrdered.add(iteratorMale.next());
            }
        }
        calculateChairs(guestOrdered);
        return guestOrdered;
    }


    private void calculateChairs(LinkedList<Guest> guestOrdenated){
        int chairNumber = 1;
        for (Guest guest:guestOrdenated) {
            guest.setChairNumber(chairNumber++);
        }
    }

    private List<Guest> filterByGender(final Gender gender, final Collection<Guest> guests){
        List<Guest> guestFiltered = guests
            .stream()
            .filter(p -> gender.equals(p.getGender()))
            .sorted((o1, o2) -> o1.getHeight().compareTo(o2.getHeight()))
            .collect(Collectors.toList());

        log.info("Qtde {}: {}", gender, guestFiltered.size());
        return guestFiltered;
    }
}
