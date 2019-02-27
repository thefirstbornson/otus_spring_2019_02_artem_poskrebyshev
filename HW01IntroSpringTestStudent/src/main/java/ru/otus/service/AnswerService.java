package ru.otus.service;

import java.util.List;

public interface AnswerService<T> {
    List<T> getAnswers();
}
