package ru.otus.view;

import ru.otus.domain.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ConsoleView {
    private final Form form;

    public ConsoleView(Form form) {
        this.form = form;
    }

    public void showMenu()  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("Программа по проведению тестирования студентов");
            System.out.println("1. Пройти тестирование");
            System.out.println("-----------------------------------------");
            System.out.print("Выберете нужный пункт меню или введите 'q' для выхода из программы: ");
            try {
                String menuOption = br.readLine();
                switch (menuOption) {
                    case "1":
                        User user = createUser();
                        List<UserAnswer> userAnswers = getTested(form, user);
                        System.out.println("Тест завершен!");
                        System.out.println();
                        System.out.println("СТУДЕНТ: "+user);
                        showResults(userAnswers);
                        System.out.println();
                        System.out.println();
                        break;
                    case "q":
                        System.exit(0);
                        break;
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String userInput(String message) {
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

    private User createUser(){
        String firstName =userInput("Введите Ваше имя: ");
        String lastName  =userInput("Введите Вашу фамилию: ");
        return new User(firstName,lastName);
    }

    private List<UserAnswer> getTested(Form form, User user){
        List<UserAnswer> userAnswers = new ArrayList<>();
        for (int k=0;k<form.getQuestionList().size();k++ ){
            Question question = form.getQuestionList().get(k);
            System.out.println(k+1+". "+question.getText());
            for(int i=0; i<question.getAnswerList().size();i++){
                System.out.print(i+1 +"." +question.getAnswerList().get(i).getText() + " ");
            }
            System.out.println();
            int choice = Integer.parseInt(userInput("Введите номер ответа: "))-1;
            Answer answer = question.getAnswerList().get(choice);
            userAnswers.add(new UserAnswer(user, question, answer));
        }
        return userAnswers;
    }

    private void showResults (List<UserAnswer> userAnswers){
        int numOfRightAnswers=0;
        for(UserAnswer userAnswer:userAnswers){
            if (userAnswer.getAnswer().isCorrect()) numOfRightAnswers++;
        }
        System.out.println("-----------------------------------------");
        System.out.println("----     РЕЗУЛЬТАТЫ ТЕСТИРОВАНИЯ     ----");
        System.out.println("-----------------------------------------");
        System.out.println("Отвечено на "+numOfRightAnswers + " вопросов из " + userAnswers.size() );
    }


}
