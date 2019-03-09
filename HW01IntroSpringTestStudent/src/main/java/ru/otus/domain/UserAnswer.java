package ru.otus.domain;

public class UserAnswer {
    private long id;
    private User user;
    private Question question;
    private Answer answer;

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

    @Override
    public String toString() {
        return "UserAnswer{" +
                "id=" + id +
                ", user=" + user +
                ", question=" + question +
                ", answer=" + answer +
                '}';
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

}
