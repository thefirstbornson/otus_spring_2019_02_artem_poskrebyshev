package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.dao.DAO;
import ru.otus.domain.Answer;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService<Answer>{
    private final DAO answerDao;

    @Autowired
    public AnswerServiceImpl(@Qualifier("answerDaoFileImpl") DAO answerDao) {
        this.answerDao = answerDao;
    }

    @Override
    public List<Answer> getAnswers() {
        return answerDao.findAll();
    }
}
