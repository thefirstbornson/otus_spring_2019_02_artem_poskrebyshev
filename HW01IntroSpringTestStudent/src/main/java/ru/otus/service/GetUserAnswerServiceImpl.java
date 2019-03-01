package ru.otus.service;

import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.domain.UserAnswer;

public class GetUserAnswerServiceImpl implements GetUserAnswerService{
    final UserAnswerSequanceService userAnswerSequanceService;

    public GetUserAnswerServiceImpl(UserAnswerSequanceService userAnswerSequanceService) {
        this.userAnswerSequanceService = userAnswerSequanceService;
    }

    @Override
    public UserAnswer getUserAnswer(User user, Question question, Answer answer) {
        return new UserAnswer(userAnswerSequanceService.getID(),user,question,answer);
    }
}
