package ru.otus.dao;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.service.SequenceService;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class AnswerDaoFileImplTest {
    @Autowired
    private AnswerDaoFileImpl dao;

    @Autowired
    @Qualifier("answerSequenceService")
    private SequenceService answerSequenceService;

    AnswerDaoFileImpl aDao= new AnswerDaoFileImpl("",answerSequenceService);

    @Test
    void parseCSV() throws IOException {
        assertTrue(dao.parseCSV().size() > 0);
    }

    @Test
    void TestNoFile(){
        assertThrows(IOException.class, ()->aDao.parseCSV());
    }

}