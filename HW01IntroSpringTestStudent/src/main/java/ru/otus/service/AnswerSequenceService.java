package ru.otus.service;

import org.springframework.stereotype.Service;

@Service
public class AnswerSequenceService implements SequenceService {
    private static long idCounter = 0;
    @Override
    public long getID() {
        return createID();
    }
    private static synchronized long createID(){
        return idCounter++;
    }
}
