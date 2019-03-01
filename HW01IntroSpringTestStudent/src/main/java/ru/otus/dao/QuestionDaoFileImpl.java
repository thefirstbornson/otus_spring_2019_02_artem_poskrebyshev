package ru.otus.dao;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import ru.otus.domain.Question;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoFileImpl extends DaoFileImpl<Question> implements DAO<Question>  {

    public QuestionDaoFileImpl(String fileName) {
        super(Question.class, fileName);
    }

    @Override
    public List<Question> parseCSV() throws IOException {

        URL resource = getClass().getClassLoader().getResource(fileName);
        CSVParser parser = new CSVParserBuilder().build();
        CSVReader qReader = new CSVReaderBuilder(new FileReader(resource.getFile())).withCSVParser(parser).build();

        List<Question> qstns = new ArrayList<>();
        String[] record = null;

        while ((record = qReader.readNext()) != null) {
            if (record.length==3){
                try {
                    Question qstn = new Question(Integer.valueOf(record[0]),record[1],Integer.valueOf(record[2]));
                    qstns.add(qstn);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }

        qReader.close();
        return qstns;

    }

}
