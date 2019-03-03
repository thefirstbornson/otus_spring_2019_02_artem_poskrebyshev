package ru.otus.dao;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.otus.Main;
import ru.otus.service.SequenceService;

import java.io.IOException;
import java.util.Locale;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
class AnswerDaoFileImplTest {
    //@Mock
    @Autowired
    @Qualifier("answerSequenceService")
    private SequenceService answerSequenceService;
    private AnswerDaoFileImpl dao;

    @Autowired
    private MessageSource messageSource;

    @Before
    void setUp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        dao = new AnswerDaoFileImpl(
                messageSource.getMessage("csv.path",new Object[]{},new Locale("ru","RU"))
                ,answerSequenceService);
    }

    @Test
    void parseCSV() {
        try {
            System.out.println(dao.parseCSV());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}