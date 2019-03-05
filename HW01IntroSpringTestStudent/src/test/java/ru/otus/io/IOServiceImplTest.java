package ru.otus.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.Main;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Main.class)
class IOServiceImplTest {
    @Autowired
    private MessageSource messageSource;


    @BeforeEach
    void setUp(){
        IOService ioService = new IOServiceImpl(messageSource);
    }

    @Test
    void printRuMes() {
            assertEquals("Программа по проведению тестирования студентов",messageSource.getMessage("test.name",new Object[]{}, new Locale("ru")));
        }

    @Test
    void printEnMes() {
        assertEquals("Student Testing Program",messageSource.getMessage("test.name",new Object[]{}, Locale.ENGLISH));
    }


}