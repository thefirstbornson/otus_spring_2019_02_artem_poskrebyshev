package ru.otus;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.view.ConsoleViewService;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args)  {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        ConsoleViewService consoleViewService = context.getBean(ConsoleViewService.class);
        consoleViewService.startInteraction();
    }
}
