package ru.otus.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.otus.domain.Answer;
import ru.otus.service.SequenceService;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnswerDaoFileImpl extends DaoFileImpl<Answer> implements DAO<Answer> {
    final SequenceService answerSequenceService;

    public AnswerDaoFileImpl(String fileName,SequenceService answerSequenceService) {
        super(Answer.class, fileName);
        this.answerSequenceService = answerSequenceService;
    }

    @Override
    public List<Answer> parseCSV() throws IOException {

        URL resource = getClass().getClassLoader().getResource(fileName);
        CSVParser parser = new CSVParserBuilder().build();
        CSVReader aReader = new CSVReaderBuilder(new FileReader(resource.getFile())).withCSVParser(parser).build();

        List<Answer> answs = new ArrayList<>();
        String[] record = null;
        int aStart =0;

        while ((record = aReader.readNext()) != null) {
            aStart = Arrays.asList(record).indexOf("#ans");
            if (aStart>0){
                try {
                    for (int i=aStart+1;i<record.length-1;i++) {
                        Answer answ = new Answer(answerSequenceService.getID()
                                                ,Integer.valueOf(record[0])
                                                ,record[i]
                                                ,Integer.valueOf(record[record.length - 1]) == i-aStart ? true : false);
                        answs.add(answ);
                    }
                } catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
        aReader.close();
        return answs;
    }
}
