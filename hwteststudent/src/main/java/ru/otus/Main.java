package ru.otus;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.config.YamlProperties;
import ru.otus.view.ConsoleViewService;

@SpringBootApplication
@EnableConfigurationProperties(YamlProperties.class)
public class Main {

    public static void main(String[] args)  {
        SpringApplication.run(Main.class, args);
//        final ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
//        final ConsoleViewService consoleViewService = context.getBean(ConsoleViewService.class);
//        consoleViewService.startInteraction();
    }
}
