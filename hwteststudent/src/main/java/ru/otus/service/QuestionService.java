package ru.otus.service;

import java.util.List;

public interface QuestionService<T> {
    List<T> getQuestions ();
}
