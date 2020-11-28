package com.example.selfcheck.service;

import com.example.selfcheck.model.Person;
import com.example.selfcheck.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository repo;

    public Person addPerson(Person p){
        return repo.save(p);
    }
    public List<Person> get(){
        return  repo.findAll();
    }
    public Optional<Person> grtById(Long id){
        return repo.findById(id);
    }
    public void delete(long id){
        repo.deleteById(id);
    }
    public Person update(Person p, Long id){
        Optional<Person> p1 = repo.findById(id);
        if(!p1.isPresent()){
           return null;
        }
        else{
            p.setId(id);
            return repo.save(p);
        }
    }
}
