package ru.otus.service;

import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.domain.UserAnswer;

public interface GetUserAnswerService {
        UserAnswer getUserAnswer(User user, Question question, Answer answer);
}
