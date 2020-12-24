package com.training.ykb.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.ykb.rest.custom.validation.StartWith;

@XmlRootElement
public class Person {

    @StartWith("is")
    @NotEmpty
    @Size(min = 2, max = 20, message = "Name 2 ile 20 arasında olmalı")
    private String name;

    @StartWith("soy")
    @NotEmpty
    @Size(min = 3, max = 25, message = "Name 3 ile 25 arasında olmalı")
    private String surname;

    @Max(value = 120, message = "Age 120 den büyük olamaz")
    @Min(value = 10, message = "Age 10 dan küçük olamaz")
    private int    age;


    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }


}
