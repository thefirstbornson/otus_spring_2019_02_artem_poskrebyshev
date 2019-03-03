package ru.otus.domain;

public class Answer {
    private long id;
    private int questionID;
    private String text;
    private boolean isCorrect;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionID=" + questionID +
                ", text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

    public Answer(long id, int questionID, String text, boolean isCorrect) {
        this.id = id;
        this.questionID = questionID;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }



}
