package pro.sisit.adapter.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import pro.sisit.adapter.IOAdapter;

// 1. TODO: написать реализацию адаптера

public abstract class CSVAdapter<T> implements IOAdapter<T> {

    private Class<T> entityType;
    private BufferedReader reader;
    private BufferedWriter writer;

    public CSVAdapter(Class<T> entityType, BufferedReader reader,
        BufferedWriter writer) {

        this.entityType = entityType;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public T read(int index) throws IOException {
        int countLine = 0;
        String line;
        reader.mark(6000);
        while ((line = reader.readLine()) != null) {
            if (countLine == index) {
                reader.reset();
                break;
            } else {
                countLine += 1;
            }
        }
        String[] parametrs;
        String splitElement = ";";
        parametrs = line.split(splitElement);
        return (T) FileReaderCommon(parametrs);

    }

    public abstract T FileReaderCommon(String[] parametrs);

    @Override
    public int append(T entity) throws IOException {
        String line = convertString(entity);
        writer.write(line);
        writer.newLine();
        writer.flush();
        int index = 0;
        while ((reader.readLine()) != null) {
            index += 1;
        }
        return index - 1;
    }

    public abstract String convertString(T entity);
}