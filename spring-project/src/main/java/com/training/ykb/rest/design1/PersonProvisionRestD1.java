package com.training.ykb.rest.design1;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionRestD1 {

    @PutMapping
    public String add(@RequestBody final Person person) {
        return "OK";
    }

    @DeleteMapping
    public String remove(@RequestParam("id") final long id) {
        return "OK";
    }

    @PatchMapping
    public String update(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping
    public String get(@RequestParam("id") final long id) {
        return "OK";
    }


}
