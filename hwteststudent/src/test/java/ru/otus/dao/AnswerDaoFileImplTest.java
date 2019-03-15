package ru.otus.dao;


import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.service.SequenceService;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class AnswerDaoFileImplTest {
    @Autowired
    private AnswerDaoFileImpl dao;

    @Autowired
    @Qualifier("answerSequenceService")
    private SequenceService answerSequenceService;

    AnswerDaoFileImpl aDao= new AnswerDaoFileImpl("wrongFileName",answerSequenceService);

    @Test
    void parseCSV() throws IOException {
        assertTrue(dao.parseCSV().size() > 0);
    }

    @Test
    void WrongNoFile(){
        assertThrows(NullPointerException.class, ()->aDao.parseCSV());
    }

}