package com.example.selfcheck.controller;

import com.example.selfcheck.model.Person;
import com.example.selfcheck.repository.PersonRepository;
import com.example.selfcheck.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService service;

    @PostMapping("/addperson")
    public Person addPerson(@RequestBody Person p){
        return service.addPerson(p);
    }
    @GetMapping("/get")
    public List<Person> getPerson(){
        return service.get();
    }
    @GetMapping("/get/{id}")
    public Optional<Person> getApp(@PathVariable("id") Long id){
        return service.grtById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.delete(id);
    }
    @PutMapping("/update/{id}")
    public Person update(@RequestBody Person p, @PathVariable("id") Long id){
        return service.update(p, id);
    }
}
