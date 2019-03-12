package ru.otus.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.Main;
import ru.otus.config.ConfigTest;
import ru.otus.config.YamlProperties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@SpringBootTest
class IOServiceImplTest {

    private IOService ioService;

    @Autowired
    @Qualifier("messageSourceTest")
    private MessageSource messageSource;
    @Autowired
    private YamlProperties yamlProperties;

    @BeforeEach
    public void setUp(){
        ioService = new IOServiceImpl(messageSource,yamlProperties);
    }

    @Test
    void printLocaleMes() {
            given(messageSource.getMessage(any(),any(),any())).willReturn(new String("1"));
            assertEquals("1",ioService.printLocaleMes("test.name"));
        }
}