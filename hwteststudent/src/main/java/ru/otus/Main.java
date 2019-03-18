package ru.otus;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.config.YamlProperties;

@SpringBootApplication
@EnableConfigurationProperties(YamlProperties.class)
public class Main {

    public static void main(String[] args)  {
        SpringApplication.run(Main.class, args);
    }
}
