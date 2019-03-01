package ru.otus;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.view.ConsoleViewService;

public class Main {
    public static void main(String[] args)  {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        ConsoleViewService consoleViewService = context.getBean(ConsoleViewService.class);
        consoleViewService.startInteraction();
    }
}
