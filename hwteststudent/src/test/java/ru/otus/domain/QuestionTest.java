package ru.otus.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    Answer answer;
    Question question;
    List<Answer> answers;


    @BeforeEach
    void setUp() {
        answer = new Answer(1,1,"yes",true);
        question = new Question(1,"Is Java OOP?",1);
        answers = new ArrayList<>();
        answers.add(answer);
        question.setAnswerList(answers);
    }


    @Test
    void getId() {
        assertEquals(1,question.getId());
    }

    @Test
    void setId() {
        question.setId(2);
        assertEquals(2,question.getId());
    }

    @Test
    void getText() {
        assertEquals("Is Java OOP?",question.getText());
    }

    @Test
    void setText() {
        question.setText("Is Java Functional Language?");
        assertEquals("Is Java Functional Language?",question.getText());
    }

    @Test
    void getMultiAnswer() {
        assertEquals(1,question.getMultiAnswer());
    }

    @Test
    void setMultiAnswer() {
        question.setMultiAnswer(2);
        assertEquals(2,question.getMultiAnswer());
    }

    @Test
    void toStringTest() {
        assertEquals("Question{id=1, text='Is Java OOP?', multiAnswer=1, answerList=[Answer{id=1, questionID=1, text='yes', isCorrect=true}]}",question.toString());
    }

    @Test
    void getAnswerList() {
        assertEquals("yes",question.getAnswerList().get(0).getText());
    }

    @Test
    void setAnswerList() {
        List<Answer> newAnswers = new ArrayList<>();
        Answer newAnswer = new Answer(1,1,"no",false);
        newAnswers.add(newAnswer);
        question.setAnswerList(newAnswers);
        assertEquals("no",question.getAnswerList().get(1).getText());

    }

}