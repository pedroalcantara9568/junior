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

@RestController
@RequestMapping("/random")
@Validated
@RequiredArgsConstructor
@Slf4j
public class DaleController {
    private static Logger logger = LoggerFactory.getLogger(DaleController.class);
    Long i = 0L;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> random() throws InterruptedException {
        i = i + 1L;
        if (i.equals(3L)) {
            i = 0L;
            Thread.sleep(1000);
            logger.info("deu bom :" + HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body("Status Aleatório:" + HttpStatus.OK);
        }
        logger.info("deu ruim :" + HttpStatus.UNPROCESSABLE_ENTITY);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Status Aleatório:" + HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
