package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;

import java.util.List;

@Service
public class QACorrespondenceServiceImpl implements QACorrespondenceService<Question> {
    private final AnswerService<Answer> answerService;
    private final QuestionService<Question> questionService;

    @Autowired
    public QACorrespondenceServiceImpl(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @Override
    public List<Question> correspondQA() {
        List<Question> qstns =questionService.getQuestions();
        List<Answer> answrs = answerService.getAnswers();
        if (qstns.size()>0) {
            for (Question question : qstns) {
                question.setAnswerList(answrs);
            }
        }
        return qstns;
    }
}
