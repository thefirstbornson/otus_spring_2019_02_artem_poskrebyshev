package ru.otus.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.Main;
import ru.otus.config.ConfigTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Main.class, ConfigTest.class})
class IOServiceImplTest {

    private IOService ioService;

    @Autowired
    @Qualifier("messageSourceTest")
    private MessageSource messageSource;

    @BeforeEach
    public void setUp(){
        ioService = new IOServiceImpl(messageSource,"","");
    }

    @Test
    void printLocaleMes() {
            given(messageSource.getMessage(any(),any(),any())).willReturn(new String("1"));
            assertEquals("1",ioService.printLocaleMes("test.name"));
        }
}