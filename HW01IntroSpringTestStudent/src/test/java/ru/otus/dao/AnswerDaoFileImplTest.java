package ru.otus.dao;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.Main;
import ru.otus.service.SequenceService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Main.class)


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