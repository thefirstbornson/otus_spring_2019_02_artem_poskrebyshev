package ru.otus.view;

import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.domain.UserAnswer;

import java.util.List;

public interface ConsoleViewService<T> {
    List<T> getTested();
    void startInteraction();
}
