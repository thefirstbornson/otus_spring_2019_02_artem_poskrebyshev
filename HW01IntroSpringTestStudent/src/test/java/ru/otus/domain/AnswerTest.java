package ru.otus.domain;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerTest {
    Answer  answer;

    @BeforeEach
    public   void init(){
        answer = new Answer(1,1,"yes",true);
    }

    @Test
    public void toStringTest() {
        assertEquals("Answer{id=1, questionID=1, text='yes', isCorrect=true}",answer.toString());
    }

    @Test
    public void getIdTest() {
        assertEquals(1,answer.getId());
    }

    @Test
    public void setIdTest(){
        answer.setId(2);
        assertEquals(2,answer.getId());
    }

    @Test
    public void getQuestionIDTest() {
        assertEquals(1,answer.getId());
    }

    @Test
    public void setQuestionIDTest() {
        answer.setQuestionID(2);
        assertEquals(2,answer.getQuestionID());
    }

    @Test
    public void getTextTest() {
        assertEquals("yes",answer.getText());
    }

    @Test
    public void setTextTest() {
        answer.setText("no");
        assertEquals("no",answer.getText());
    }

    @Test
    public void isCorrectTest() {
        assertEquals(true,answer.isCorrect());
    }

    @Test
    public void setCorrectTest() {
        answer.setCorrect(false);
        assertEquals(false,answer.isCorrect());
    }
}
