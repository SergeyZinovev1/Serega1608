package pro.sisit.adapter.impl;

import pro.sisit.model.Book;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public class CSVAdapterBook extends CSVAdapter<Book> {
    public CSVAdapterBook(Class entityType, BufferedReader reader, BufferedWriter writer) {
        super(entityType, reader, writer);
    }
    @Override
    public Book FileReaderCommon(String[] parametrs) {
        Book newBook = new Book(parametrs[0], parametrs[1], parametrs[2], parametrs[3]);
        return newBook;
    }

    @Override
    public String convertString(Book entity) {
        return String.format("%s;%s;%s;%s", entity.getName(), entity.getAuthor(),entity.getGenre(),entity.getIsbn());
    }
}