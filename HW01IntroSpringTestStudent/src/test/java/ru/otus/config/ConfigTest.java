package ru.otus.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.io.IOService;
import ru.otus.io.IOServiceImpl;

@Configuration
public class ConfigTest {

    @Bean
    public MessageSource messageSourceTest(){
        return Mockito.mock(MessageSource.class);
    }


}