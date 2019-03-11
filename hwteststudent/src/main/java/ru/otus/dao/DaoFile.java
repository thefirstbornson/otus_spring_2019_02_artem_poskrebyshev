package ru.otus.dao;

import java.io.IOException;
import java.util.List;

public interface DaoFile<T> extends DAO<T> {
    List<T> parseCSV() throws IOException;
}
