package ru.otus.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.dao.AnswerDaoFileImpl;
import ru.otus.dao.DAO;
import ru.otus.dao.QuestionDaoFileImpl;

import java.time.temporal.ValueRange;


@Configuration
public class DaoConfig {

    @Value("${csv.path}")
    private String csvPath;
    @Bean
    public DAO answerDaoFileImpl(){
        return new AnswerDaoFileImpl(csvPath);
    }

    @Bean
    public DAO questionDaoFileImpl(){
        return new QuestionDaoFileImpl(csvPath);
    }

}
