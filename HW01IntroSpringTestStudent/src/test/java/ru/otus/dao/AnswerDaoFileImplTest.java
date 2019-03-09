package ru.otus.dao;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.Main;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Main.class)
class AnswerDaoFileImplTest {
    @Autowired
    private AnswerDaoFileImpl dao;

    @Test
    void parseCSV() throws IOException {
        assertTrue(dao.parseCSV().size() > 0);
    }
}