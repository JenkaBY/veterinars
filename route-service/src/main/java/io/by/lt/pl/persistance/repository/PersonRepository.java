package io.by.lt.pl.persistance.repository;

import io.by.lt.pl.persistance.entity.PersonEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepository {
    private final JdbcClient jdbcClient;
    private final PersonRowMapper personRowMapper;

    public PersonRepository(JdbcClient jdbcClient, PersonRowMapper personRowMapper) {
        this.jdbcClient = jdbcClient;
        this.personRowMapper = personRowMapper;
    }

    public List<PersonEntity> findAll() {
        return jdbcClient.sql("SELECT * FROM person")
                .query(PersonEntity.class)
//                .query(personRowMapper)
                .list();
    }

    public PersonEntity createPerson(PersonEntity person) {

        var generatedKeyHolder = new GeneratedKeyHolder();
        jdbcClient.sql("INSERT INTO person(name, address, city) values (:name, :address, :city)")
                .paramSource(person)
                .update(generatedKeyHolder);

        return new PersonEntity(
                generatedKeyHolder.getKeyAs(Integer.class),
                person.name(),
                person.address(),
                person.city()
        );
    }


    @Component
    public static class PersonRowMapper implements RowMapper<PersonEntity> {
        @Override
        public PersonEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new PersonEntity(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("city"));
        }
    }
}
