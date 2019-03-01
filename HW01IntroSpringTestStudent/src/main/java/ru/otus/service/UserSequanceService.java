package ru.otus.service;

public class UserSequanceService implements SequenceService {
    private static long idCounter = 0;
    @Override
    public long getID() {
        return createID();
    }
    private static synchronized long createID(){
        return idCounter++;
    }
}
