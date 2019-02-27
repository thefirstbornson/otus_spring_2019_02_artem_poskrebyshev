package ru.otus.service;

import ru.otus.dao.DAO;
import ru.otus.domain.Answer;

import java.util.List;

public class AnswerServiceImpl implements AnswerService<Answer>{
    private final DAO answerDao;

    public AnswerServiceImpl(DAO answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    public List<Answer> getAnswers() {
        return answerDao.findAll();
    }
}
