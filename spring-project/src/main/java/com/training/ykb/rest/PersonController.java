package com.training.ykb.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pc")
public class PersonController {

    @PostMapping("/add")
    public String add(@Validated @RequestBody final Person person) {
        if (person.getAge() > 120) {
            throw new IllegalArgumentException("Age 120 den büyük olamaz");
        }
        return "" + person;
    }

    @PostMapping("/add2")
    public ResponseEntity<String> add2(@Validated @RequestBody final Person person) {
        if (person.getAge() > 120) {
            throw new IllegalArgumentException("Age 120 den büyük olamaz");
        }
        return ResponseEntity.status(287)
                             .header("ip",
                                     "192.168.1.1")
                             .body("" + person);
    }

    @PostMapping("/add3")
    public ResponseEntity<String> add3(@Validated @RequestBody final Person person,
                                       final HttpServletRequest hsr,
                                       final HttpHeaders httpRequest) {
        if (person.getAge() > 80) {
            throw new IllegalArgumentException("Age 120 den büyük olamaz");
        }
        return ResponseEntity.status(287)
                             .body("" + person);
    }

}
