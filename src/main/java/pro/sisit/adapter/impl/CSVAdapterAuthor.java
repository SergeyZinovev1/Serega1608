package pro.sisit.adapter.impl;



import pro.sisit.model.Author;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class CSVAdapterAuthor extends CSVAdapter<Author> {
    public CSVAdapterAuthor(Class entityType, BufferedReader reader, BufferedWriter writer) {
        super(entityType, reader, writer);
    }
    @Override
    public Author FileReaderCommon(String[] parametrs) {
        Author newAuthor = new Author(parametrs[0], parametrs[1]);
        return newAuthor;
    }

    @Override
    public String convertString(Author entity) {
        return String.format("%s;%s;%s;%s", entity.getName(), entity.getBirthPlace());
    }




}