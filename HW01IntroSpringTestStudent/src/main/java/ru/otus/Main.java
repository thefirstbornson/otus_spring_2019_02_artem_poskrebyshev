package ru.otus;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.domain.Form;
import ru.otus.domain.Question;
import ru.otus.service.QACorrespondenceService;
import ru.otus.view.ConsoleView;
import ru.otus.view.ConsoleViewService;

import java.util.List;

public class Main {
    public static void main(String[] args)  {
        //Form form = new Form("Java test");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        //QACorrespondenceService<Question> qaCorrespondenceService = context.getBean(QACorrespondenceService.class);
        //List<Question> questionList = qaCorrespondenceService.correspondQA();
       // form.setQuestionList(questionList);
       // new ConsoleView(form).showMenu();
        ConsoleViewService consoleViewService = context.getBean(ConsoleViewService.class);
        consoleViewService.startInteraction();
    }
}
