package ru.otus.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.dao.AnswerDaoFileImpl;
import ru.otus.dao.DAO;
import ru.otus.dao.DaoFile;
import ru.otus.dao.QuestionDaoFileImpl;
import ru.otus.domain.Answer;
import ru.otus.domain.Question;
import ru.otus.service.SequenceService;


@Configuration
public class DaoConfig {

   @Value("${qa.path}")
   private String path;
   @Value("${locale.lang}")
   private String language;
   @Value("${file.ext}")
   private String extension;


   @Bean
    public DaoFile<Answer> answerDaoFileImpl(@Qualifier("answerSequenceService") SequenceService answerSequenceService){
        return new AnswerDaoFileImpl(path+language+extension, answerSequenceService);
    }

    @Bean
    public DaoFile<Question> questionDaoFileImpl(){
        return new QuestionDaoFileImpl(path+language+extension);
    }

}
