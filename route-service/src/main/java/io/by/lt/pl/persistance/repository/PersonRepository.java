package io.by.lt.pl.persistance.repository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    private final JdbcClient jdbcClient;

    public PersonRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

//    public PersonEntity createPerson() {
//        return jdbcClient.sql().query();
//    }
}
