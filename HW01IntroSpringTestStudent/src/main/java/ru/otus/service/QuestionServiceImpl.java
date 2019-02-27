package ru.otus.service;

import ru.otus.dao.DAO;
import ru.otus.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService<Question> {
    private final DAO questionDao;
    public QuestionServiceImpl(DAO questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestions() {
        return questionDao.findAll();
    }
}
