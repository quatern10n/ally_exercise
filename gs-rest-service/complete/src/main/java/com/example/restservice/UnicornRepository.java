package com.example.restservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UnicornRepository extends CrudRepository<Unicorn, Long> {

  List<Unicorn> findAll();

  Unicorn findById(long id);
}


