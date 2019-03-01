package ru.otus.io;

import org.springframework.stereotype.Service;
import ru.otus.domain.UserAnswer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class IOServiceImpl implements IOService<UserAnswer>{
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

    @Override
    public void showMenu()  {
            System.out.println("-----------------------------------------");
            System.out.println("Программа по проведению тестирования студентов");
            System.out.println("1. Пройти тестирование");
            System.out.println("-----------------------------------------");
    }

    public void showResults (List<UserAnswer> userAnswers){
        int numOfRightAnswers=0;
        for(UserAnswer userAnswer:userAnswers){
            if (userAnswer.getAnswer().isCorrect()) numOfRightAnswers++;
        }
        System.out.println();
        System.out.println("Тест завершен!");
        System.out.println("СТУДЕНТ: "+userAnswers.get(0).getUser());
        System.out.println("-----------------------------------------");
        System.out.println("----     РЕЗУЛЬТАТЫ ТЕСТИРОВАНИЯ     ----");
        System.out.println("-----------------------------------------");
        System.out.println("Отвечено на "+numOfRightAnswers + " вопросов из " + userAnswers.size() );
        System.out.println();
        System.out.println();
    }

    @Override
    public void showText(String text) {
        System.out.print(text);
    }
}
