package ru.otus.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserAnswerTest {
    Answer answer;
    Question question;
    List<Answer> answers;
    User user;
    UserAnswer userAnswer;

    @BeforeEach
    void setUp() {
        answer = new Answer(1,1,"yes",true);
        question = new Question(1,"Is Java OOP?",1);
        user = new User(1,"Ivan","Ivanov");
        userAnswer = new UserAnswer(1,user,question,answer);
    }

    @Test
    void getId() {
        assertEquals(1,userAnswer.getId());
    }

    @Test
    void getUser() {
        assertEquals(user,userAnswer.getUser());
    }

    @Test
    void setUser() {
        User newUser = new User(2, "Paolo","Petrov");
        userAnswer.setUser(newUser);
        assertEquals(newUser,userAnswer.getUser());
    }

    @Test
    void getQuestion() {
        assertEquals(question,userAnswer.getQuestion());
    }

    @Test
    void setQuestion() {
        Question newQuestion = new Question(2, "Is Java Functional Language?",1);
        userAnswer.setQuestion(newQuestion);
        assertEquals(newQuestion, userAnswer.getQuestion());
    }

    @Test
    void getAnswer() {
        assertEquals(answer,userAnswer.getAnswer());
    }

    @Test
    void setAnswer() {
        Answer newAnswer = new Answer(2,2,"no",true);
        userAnswer.setAnswer(newAnswer);
        assertEquals(newAnswer,userAnswer.getAnswer());
    }

    @Test
    void toStringTest(){
        assertEquals("UserAnswer{id=1, user=Ivan Ivanov, question=Question{id=1, text='Is Java OOP?', multiAnswer=1, answerList=[]}, answer=Answer{id=1, questionID=1, text='yes', isCorrect=true}}", userAnswer.toString());
    }
}