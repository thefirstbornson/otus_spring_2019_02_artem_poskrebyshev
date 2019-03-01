package ru.otus.domain;

public class UserAnswer {
    private long id;
    private User user;
    private Question question;
    private Answer answer;
    private static long idCounter = 0;

    public UserAnswer(long id,User user, Question question, Answer answer) {
        this.id = id;
        this.user = user;
        this.question = question;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public static long getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(long idCounter) {
        UserAnswer.idCounter = idCounter;
    }
}
