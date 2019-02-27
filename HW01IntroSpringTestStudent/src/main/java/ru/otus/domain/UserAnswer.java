package ru.otus.domain;

public class UserAnswer {
    private long id;
    private User user;
    private Form form;
    private Question question;
    private Answer answer;
    private static long idCounter = 0;

    private static synchronized long createID() {
        return idCounter++;
    }

    public UserAnswer(User user, Form form, Question question, Answer answer) {
        this.id = createID();
        this.user = user;
        this.form = form;
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

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
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
