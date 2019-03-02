package ru.otus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.dao.AnswerDaoFileImpl;
import ru.otus.dao.DAO;
import ru.otus.dao.QuestionDaoFileImpl;

import java.time.temporal.ValueRange;
import java.util.Locale;


@Configuration
public class DaoConfig {
    @Autowired
    private MessageSource messageSource;

   // @Value("${csv.path}")
    public static final Locale LOCALE = new Locale("ru","RU");//Locale.ENGLISH;
    @Bean
    public DAO answerDaoFileImpl(){
        return new AnswerDaoFileImpl(getCsvPath(LOCALE));
    }

    @Bean
    public DAO questionDaoFileImpl(){
        return new QuestionDaoFileImpl(getCsvPath(LOCALE));
    }

    public String getCsvPath(Locale locale){
        return messageSource.getMessage("csv.path",new Object[]{},locale);
    }
}
