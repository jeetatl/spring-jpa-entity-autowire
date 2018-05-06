package com.jeetatl.spring.springjpa.config;

import com.jeetatl.spring.springjpa.domain.Person;
import com.jeetatl.spring.springjpa.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SampleDataConfig {

    private static final Logger log = LoggerFactory.getLogger(SampleDataConfig.class);

    private PersonRepository personRepository;

    @PostConstruct
    public void postConstruct() {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Doe");
        personRepository.save(person);
        log.info(person.toString());

        log.info("Finding person with id 1: " + personRepository.findById(1L));
    }

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
