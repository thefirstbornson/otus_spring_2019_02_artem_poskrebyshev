package ru.otus.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import ru.otus.domain.Question;
import ru.otus.service.SequenceService;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionDaoFileImpl extends DaoFileImpl<Question> implements DAO<Question>  {


    public QuestionDaoFileImpl(String fileName) {
        super(Question.class, fileName);
    }

    @Override
    public List<Question> parseCSV() throws IOException {

        CSVReader qReader = new CSVReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName)));


        List<Question> qstns = new ArrayList<>();
        String[] record = null;

        while ((record = qReader.readNext()) != null) {
            if (Arrays.asList(record).indexOf("#ans")==3){
                try {
                    Question qstn = new Question(Long.valueOf(record[0]),record[1],Integer.valueOf(record[2]));
                    qstns.add(qstn);
                } catch (NullPointerException | NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }

        qReader.close();
        return qstns;

    }

}
