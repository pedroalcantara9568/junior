package com.alquiteto.junior.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/random")
@Validated
@RequiredArgsConstructor
@Slf4j
public class DaleController {
    private static Logger logger = LoggerFactory.getLogger(DaleController.class);
    Long i = 0L;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> custom() throws InterruptedException {
        var statusList = List.of(HttpStatus.values());
        logger.info("dale");
        Random random = new Random();
        int index = random.nextInt(statusList.size());
        HttpStatus randomStatus = statusList.get(index);
        i = i + 1L;
        if (i == 7) {
            i = 0L;
            return ResponseEntity.status(HttpStatus.OK).body("Status Aleatório:" + HttpStatus.OK);
        }

        return ResponseEntity.status(randomStatus).body("Status Aleatório:" + randomStatus);
    }
}
