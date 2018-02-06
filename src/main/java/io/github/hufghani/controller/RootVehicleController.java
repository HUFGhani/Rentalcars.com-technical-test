package io.github.hufghani.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
public class RootVehicleController {

    @RequestMapping(path = "", method = { RequestMethod.GET }, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("endpoints:<br/>/vehicles - list the vehicle related endpoints.");
    }
}
