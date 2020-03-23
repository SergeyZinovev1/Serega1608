package pro.sisit.adapter;

import java.io.IOException;

public interface IOAdapter<T> {
    T read(int index) throws IOException;


    int append(T entity) throws IOException;
}
