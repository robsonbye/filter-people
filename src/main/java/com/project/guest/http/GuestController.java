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

    private final ConvertFileToGuest convertFileToInvited;
    private final GuestRules invitedRules;

    @Autowired
    public GuestController(final ConvertFileToGuest convertFileToInvited, final GuestRules invitedRules) {
        this.convertFileToInvited = convertFileToInvited;
        this.invitedRules = invitedRules;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void generatePositionChair(
        @RequestHeader(name = "file_path", required = true) final String filePath){
        log.info("Caminho do Arquivo {}", filePath);
        Collection<Guest> inviteds = convertFileToInvited.convert(filePath);
        log.info("tamanho arquivo {}", inviteds.size());
        //invitedRules.classifyInvited(inviteds);
    }


}
