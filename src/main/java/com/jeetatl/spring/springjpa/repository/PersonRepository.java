package com.jeetatl.spring.springjpa.repository;

import com.jeetatl.spring.springjpa.domain.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
