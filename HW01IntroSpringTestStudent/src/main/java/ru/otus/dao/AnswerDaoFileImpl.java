package ru.otus.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Repository;
import ru.otus.domain.Answer;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class AnswerDaoFileImpl extends DaoFileImpl<Answer> implements DAO<Answer> {

    public AnswerDaoFileImpl(String fileName) {
        super(Answer.class, fileName);
    }

    @Override
    public List<Answer> parseCSV() throws IOException {

        URL resource = getClass().getClassLoader().getResource(fileName);
        CSVParser parser = new CSVParserBuilder().build();
        CSVReader aReader = new CSVReaderBuilder(new FileReader(resource.getFile())).withCSVParser(parser).build();

        List<Answer> answs = new ArrayList<>();
        String[] record = null;
        int aStart = Arrays.binarySearch(record,"ans")+1;

        while ((record = aReader.readNext()) != null) {
                for (int i=aStart;i<record.length-1;i++) {
                    Answer answ = new Answer(Integer.valueOf(record[0]), record[i]
                                            ,Integer.valueOf(record[record.length - 1]) == i ? true : false);
                    answs.add(answ);
                }
        }


        aReader.close();
        return answs;
    }
}
