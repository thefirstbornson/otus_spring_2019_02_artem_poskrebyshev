package ru.otus.domain;

public class Answer {
    private int id;
    private int questionID;
    private String text;
    private boolean isCorrect;
    private static int idCounter = 0;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", questionID=" + questionID +
                ", text='" + text + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

    public Answer(int questionID, String text, boolean isCorrect) {
        this.id = createID();
        this.questionID = questionID;
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public int getId() {
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

    public static synchronized int createID()
    {
        return idCounter++;
    }


}
