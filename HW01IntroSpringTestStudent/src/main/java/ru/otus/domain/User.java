package ru.otus.domain;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private static long idCounter = 0;

    public long getId() {
        return id;
    }

    public void setId() {
        this.id = createID();
    }

    public User() {
    }

    public User(String firstName, String lastName) {
        this.id = createID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    private static synchronized long createID()
    {
        return idCounter++;
    }

    @Override
    public String toString() {
        return firstName + " "+lastName ;
    }


}
