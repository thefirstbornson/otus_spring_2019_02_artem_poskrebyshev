package ru.otus.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User(1,"Ivan","Ivanov");
    }

    @Test
    void getId() {
        assertEquals(1,user.getId());
    }

    @Test
    void setId() {
        user.setId(2);
        assertEquals(2,user.getId());
    }

    @Test
    void getFirstName() {
        assertEquals("Ivan",user.getFirstName());
    }

    @Test
    void setFirstName() {
        user.setFirstName("Oleg");
        assertEquals("Oleg", user.getFirstName());
    }

    @Test
    void getLastName() {
        assertEquals("Ivanov", user.getLastName());
    }

    @Test
    void setLastName() {
        user.setLastName("Petrov");
        assertEquals("Petrov", user.getLastName());
    }

    @Test
    void toStringTest() {
        assertEquals("Ivan Ivanov", user.toString());
    }
}