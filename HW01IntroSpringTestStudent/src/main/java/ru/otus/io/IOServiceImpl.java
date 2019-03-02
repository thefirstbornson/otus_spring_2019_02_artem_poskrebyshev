package ru.otus.io;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.config.DaoConfig;
import ru.otus.domain.UserAnswer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class IOServiceImpl implements IOService<UserAnswer>{
    private final MessageSource messageSource;

    @Autowired
    public IOServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String userInput(String message) {
        String input=null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(message);
            input = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public String printLocaleMes(String filePropField){
       return messageSource.getMessage(filePropField,new Object[]{}, DaoConfig.LOCALE);
    }

    @Override
    public void showMenu()  {
            System.out.println("-----------------------------------------");
            System.out.println(printLocaleMes("test.name"));
            System.out.println(printLocaleMes("test.menuOption1"));
            System.out.println("-----------------------------------------");
    }

    public void showResults (List<UserAnswer> userAnswers){
        int numOfRightAnswers=0;
        if (userAnswers.size()>0){
            for(UserAnswer userAnswer:userAnswers){
                if (userAnswer.getAnswer().isCorrect()) numOfRightAnswers++;
            }
            System.out.println();
            System.out.println(printLocaleMes("test.completed")+"!");
            System.out.println(printLocaleMes("test.student")+": "+userAnswers.get(0).getUser());
            System.out.println("-----------------------------------------");
            System.out.println("----     " +printLocaleMes("test.results")+"     ----");
            System.out.println("-----------------------------------------");
            System.out.println(printLocaleMes("test.rightAnsw")+ " "+numOfRightAnswers
                            +" "+ printLocaleMes("test.numAnsw") +" "+ userAnswers.size() );
            System.out.println();
            System.out.println();
        } else System.out.println(printLocaleMes("test.loadFileError"));
    }

    @Override
    public void showText(String text) {
        System.out.print(text);
    }
}
