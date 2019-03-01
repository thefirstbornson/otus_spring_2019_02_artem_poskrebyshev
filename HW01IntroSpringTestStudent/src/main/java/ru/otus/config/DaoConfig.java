package ru.otus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.dao.AnswerDaoFileImpl;
import ru.otus.dao.DAO;
import ru.otus.dao.QuestionDaoFileImpl;

@Configuration
public class DaoConfig {
    @Bean
    public DAO answerDaoFileImpl(){
        return new AnswerDaoFileImpl("csv/questions_answers.csv");
    }

    @Bean
    public DAO questionDaoFileImpl(){
        return new QuestionDaoFileImpl("csv/questions_answers.csv");
    }

}
