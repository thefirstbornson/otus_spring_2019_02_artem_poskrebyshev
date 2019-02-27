package ru.otus.domain;

import java.util.ArrayList;
import java.util.List;

public class Form {
    private int id;
    private String name;
    private List<Question> questionList;
    private static int idCounter = 0;


    public Form() {
    }

    public Form(String name) {
        this.id = createID();
        this.name = name;
        this.questionList = new ArrayList<>();
    }
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    private static synchronized int createID()
    {
        return idCounter++;
    }

    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", questionList=" + questionList +
                '}';
    }

}
