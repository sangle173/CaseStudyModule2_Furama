package Controllers;

import Models.Villa;

import java.util.List;

public interface CRUDService<E> {
    List<E> read();

    void show();

    void searchById();

    List<E> create();

    void add();

    void update(E e, String id);

    void delete(String id);
}
