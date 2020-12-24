package com.training.ykb.rest.design2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.ykb.rest.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionRestD2 {

    @PostMapping("/add")
    public String add(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") final long id) {
        return "OK";
    }

    @PostMapping("/update")
    public String update(@RequestBody final Person person) {
        return "OK";
    }

    @GetMapping("/get")
    public String get(@RequestParam("id") final long id) {
        return "OK";
    }

    @GetMapping("/getall")
    public List<Person> getall() {
        return null;
    }

}
