package ru.otus.io;

import ru.otus.domain.UserAnswer;

import java.util.List;

public interface IOService<T> {
    void showMenu();

    String userInput(String message);

    void showResults(List<T> userAnswers);

    void showText(String text);
    String printLocaleMes(String filePropField);

    void setLanguage(String language);
}