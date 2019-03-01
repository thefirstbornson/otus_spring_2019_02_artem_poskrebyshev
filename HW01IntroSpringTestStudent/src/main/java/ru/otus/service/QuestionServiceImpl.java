package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.otus.dao.DAO;
import ru.otus.domain.Question;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService<Question> {
    private final DAO questionDao;

    @Autowired
    public QuestionServiceImpl(@Qualifier("questionDaoFileImpl") DAO questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestions() {
        return questionDao.findAll();
    }
}
