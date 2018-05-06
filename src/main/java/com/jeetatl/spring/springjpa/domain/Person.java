package com.jeetatl.spring.springjpa.domain;

import com.jeetatl.spring.springjpa.config.AppCtx;
import com.jeetatl.spring.springjpa.service.DummyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    private static final Logger log = LoggerFactory.getLogger(Person.class);

    private Long id;
    private String firstName;
    private String lastName;

    @Transient
    private DummyService dummyService;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Autowired
    public void setDummyService(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @PrePersist
    public void perPersist() {
        AppCtx.getBeanFactory().autowireBean(this);
        log.info("PrePersist: " + this.dummyService);
    }

    @PostLoad
    public void postLoad() {
        log.info("PostLoad: " + this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dummyService=" + dummyService +
                '}';
    }
}
