package ru.otus.config;

import org.springframework.beans.factory.annotation.Autowired;
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

import javax.xml.ws.soap.Addressing;


@Configuration
public class DaoConfig {


   @Bean
   @Autowired
    public DaoFile<Answer> answerDaoFileImpl(@Qualifier("answerSequenceService") SequenceService answerSequenceService
                                            ,YamlProperties yamlProperties){
       return new AnswerDaoFileImpl(yamlProperties.getQaPath()
                                   +yamlProperties.getLocaleLang()
                                   +yamlProperties.getFileExt(),answerSequenceService);
    }

    @Bean
    @Autowired
    public DaoFile<Question> questionDaoFileImpl(YamlProperties yamlProperties){
        return new QuestionDaoFileImpl(yamlProperties.getQaPath()
                                        +yamlProperties.getLocaleLang()
                                        +yamlProperties.getFileExt());
    }

}
