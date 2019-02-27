package ru.otus.dao;

import java.io.IOException;
import java.util.List;

public abstract class DaoFileImpl<T> implements DAO <T> {
    final Class<T> entityClass;
    final String fileName;

    DaoFileImpl(Class<T> entityClass, String fileName) {
        this.entityClass = entityClass;
        this.fileName = fileName;
    }

    @Override
    public List<T> findAll()  {
        try {
            return parseCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T getByID(int id) {
        try {
            return parseCSV().get(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract List<T> parseCSV() throws IOException;
}
