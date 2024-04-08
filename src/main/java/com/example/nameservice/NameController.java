package com.example.nameservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {
    private NameMapper nameMapper;

    public NameController(NameMapper nameMapper) {
        this.nameMapper = nameMapper;
    }

    @GetMapping("/names")
    public List<Name> findByNames(@RequestParam String startsWith) {
        return nameMapper.findByNameStartingWith(startsWith);
    }
}




