package com.training.ykb.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/first")
public class FirstRest {

    @GetMapping("/hello2/{xyz}/{abc}")
    public String hello2(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello 2 " + name + " " + surname;
    }

    @GetMapping("/hello2/osman/yay")
    public String hello2X() {
        return "Hello 2 Test ";
    }

    @GetMapping("/hello3/isim/{xyz}/name/{abc}")
    public String hello3(@PathVariable("xyz") final String name,
                         @PathVariable("abc") final String surname) {
        return "Hello 3 " + name + " " + surname;
    }

    @GetMapping("/hello4")
    public String hello4(@RequestParam("fgh") final String name,
                         @RequestParam("jkl") final String surname) {
        return "Hello 4 " + name + " " + surname;
    }

    @GetMapping("/hello5/{fgh}")
    public String hello5(@PathVariable("fgh") final String name,
                         @RequestParam("jkl") final String surname) {
        return "Hello 5 " + name + " " + surname;
    }

    @GetMapping("/hello6")
    public String hello6(@RequestHeader("isim") final String name,
                         @RequestHeader("soyisim") final String surname) {
        return "Hello 6 " + name + " " + surname;
    }

    @PostMapping("/hello7")
    public String hello7(@RequestBody final Person person) {
        return "Hello 7 " + person;
    }

    @PostMapping("/hello8")
    public Person hello8(@RequestBody final Person person) {
        person.setAge(99);
        return person;
    }

    @PutMapping("/hello8")
    public Person hello8put(@RequestBody final Person person) {
        person.setAge(99);
        return person;
    }

    @PatchMapping("/hello8")
    public Person hello8patch(@RequestBody final Person person) {
        person.setAge(99);
        return person;
    }

    @PatchMapping("/hello9")
    public String hello8patch(@RequestBody final String personstr) {
        ObjectMapper mapperLoc = new ObjectMapper();
        try {
            Person readValueLoc = mapperLoc.readValue(personstr,
                                                      Person.class);
            System.out.println(readValueLoc);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return personstr;
    }

    @PostMapping(value = "/hello10",
                 consumes = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 },
                 produces = {
                              MediaType.APPLICATION_JSON_VALUE,
                              MediaType.APPLICATION_XML_VALUE
                 })
    public Person hello10(@RequestBody final Person person) {
        person.setAge(99);
        return person;
    }


    // -------------------------------------
    @GetMapping("/hello")
    public String hello() {
        return "Hello world GET";
    }

    @GetMapping("/hello/my/friend/osman/naber")
    public String helloX() {
        return "Hello world GET2";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "Hello world POST";
    }

    @PutMapping("/hello")
    public String helloPut() {
        return "Hello world PUT";
    }

    @DeleteMapping("/hello")
    public String helloDelete() {
        return "Hello world DELETE";
    }

    @PatchMapping("/hello")
    public String helloPatch() {
        return "Hello world PATCH";
    }


}
