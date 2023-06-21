package com.example.gettingstartedspringbootjpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorRepository extends CrudRepository<Processor, Integer> {

}
