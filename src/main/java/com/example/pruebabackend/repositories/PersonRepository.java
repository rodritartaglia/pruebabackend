package com.example.pruebabackend.repositories;

import com.example.pruebabackend.entities.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> getPersonByFirstNameIgnoreCase(String name);

    List<Person> findByOrderByLastNameAsc();

}
