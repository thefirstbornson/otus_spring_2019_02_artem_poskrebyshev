package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.domain.User;
import ru.otus.domain.UserAnswer;

@Service
public class GetUserAnswerServiceImpl implements GetUserAnswerService{
    final SequenceService userAnswerSequenceService;

    @Autowired
    public GetUserAnswerServiceImpl(@Qualifier("userAnswerSequenceService") SequenceService userAnswerSequenceService) {
        this.userAnswerSequenceService = userAnswerSequenceService;
    }

    @Override
    public UserAnswer getUserAnswer(User user, Question question, Answer answer) {
        return new UserAnswer(userAnswerSequenceService.getID(),user,question,answer);
    }
}
