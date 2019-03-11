package ru.otus.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.Main;
import ru.otus.config.ConfigTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionDaoFileImplTest {
    @Autowired
    private QuestionDaoFileImpl dao;

    @Test
    void parseCSV() throws IOException {
        assertTrue(dao.parseCSV().size() > 0);
    }
}