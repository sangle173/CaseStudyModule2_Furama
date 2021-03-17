package Controllers;

import Commons.*;
import Models.Villa;

import java.util.List;

public interface CRUDService<E> {
    List<E> read();

    void show();

    void searchById();

    List<E> create() throws NameException, EmailException, GenderException, IdCardException, BirthdayException;

    void add() throws NameException, EmailException, GenderException, IdCardException, BirthdayException;

    void update() throws NameException, BirthdayException, GenderException, IdCardException, EmailException;

    void delete();
}
