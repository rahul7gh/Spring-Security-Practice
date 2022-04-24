package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.components.JpaAuthority;

public interface JpaAuthorityRepository extends CrudRepository<JpaAuthority, Long> {

}
