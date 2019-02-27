package ru.otus.service;

import ru.otus.domain.Answer;
import ru.otus.domain.Question;

import java.util.List;

public class QACorrespondenceServiceImpl implements QACorrespondenceService<Question> {
    private final AnswerService<Answer> answerService;
    private final QuestionService<Question> questionService;

    public QACorrespondenceServiceImpl(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @Override
    public List<Question> correspondQA() {
        List<Question> qstns =questionService.getQuestions();
        List<Answer> answrs = answerService.getAnswers();
        for (Question question :qstns ) {
            question.setAnswerList(answrs);

        }
        return qstns;
    }
}
