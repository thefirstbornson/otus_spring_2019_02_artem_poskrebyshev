package ru.otus.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private String text;
    private int multiAnswer=1;
    private List<Answer> answerList;

    public Question(int id, String text, int multiAnswer) {
        this.id = id;
        this.text = text;
        this.multiAnswer = multiAnswer;
        this.answerList = new ArrayList<>();
    }



    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        for (Answer answer:answerList){
            if (this.getId()==answer.getQuestionID()) this.answerList.add(answer);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




    public int getMultiAnswer() {
        return multiAnswer;
    }

    public void setMultiAnswer(int multiAnswer) {
        this.multiAnswer = multiAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", multiAnswer=" + multiAnswer +
                ", answerList=" + answerList +
                '}';
    }
}
