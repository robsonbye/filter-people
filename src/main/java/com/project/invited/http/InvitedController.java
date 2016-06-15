package com.project.invited.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by robson.andrade on 13/06/2016.
 */
@RestController
@RequestMapping("/api/invited")
@Slf4j
public class InvitedController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void generatePositionChair(
        @RequestHeader(name = "file_path", required = true) final String filePath){
        log.info("Caminho do Arquivo {}", filePath);
        String text = readFile(filePath);
        log.info(text);
    }

    private String readFile(String path){
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            log.error("Error to try open file",e);
        }
        return content;

    }
}
