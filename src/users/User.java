package users;

import operation.*;
import test.BookList;

import java.util.Scanner;

public abstract class User {

    protected String name;
    protected IOperation[] iOperations ;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
    public void doOperation(int choice, BookList bookList){
        this.iOperations[choice].work(bookList);
    }
}

