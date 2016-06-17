package com.project.guest.http;

import com.project.guest.converter.ConvertFileToGuest;
import com.project.guest.domains.Guest;
import com.project.guest.usecases.GuestRules;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by robson.andrade on 13/06/2016.
 */
@RestController
@RequestMapping("/api/guest")
@Slf4j
public class GuestController {

    private final ConvertFileToGuest convertFileToGuest;
    private final GuestRules guestRules;
    private int chairNumber1 = 1;

    @Autowired
    public GuestController(final ConvertFileToGuest convertFileToInvited, final GuestRules invitedRules) {
        this.convertFileToGuest = convertFileToInvited;
        this.guestRules = invitedRules;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void classifyGuest(
        @RequestHeader(name = "file_path", required = true) final String filePath){
        log.info("Caminho do Arquivo {}", filePath);
        Collection<Guest> guests = convertFileToGuest.convert(filePath);
        log.info("tamanho arquivo {}", guests.size());
        Collection<Guest> guestsClassified = guestRules.classify(guests);
        log.info("lista ordenada");

        guestsClassified.forEach(System.out::println);
    }



}
