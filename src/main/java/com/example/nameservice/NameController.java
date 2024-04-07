package com.example.nameservice;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
@ExceptionHandler(value = NameNotFoundException.class)
public ResponseEntity<Map<String, String>> handleUserNotFoundException(
        NotFoundException e, HttpServletRequest request) {
    Map<String, String> body = Map.of(
            "timestamp", ZonedDateTime.now().toString(),
            "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
            "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
            "message", e.getMessage(),
            "path", request.getRequestURI());
    return new ResponseEntity(body, HttpStatus.NOT_FOUND);
}



