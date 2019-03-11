package ru.otus.dao;

import java.io.IOException;
import java.util.List;

public interface DAO <T> {
   T getByID (int id);
   List<T> findAll();
}
