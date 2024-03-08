package io.by.lt.pl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest(classes = RouteApplication.class)
class RouteApplicationTest {

    @Test
    void startUp(){
        assertTrue(true, RouteApplication.class + " could not start");
    }
}