package operation;

import test.Book;
import test.BookList;

import java.util.Scanner;

public class DisplayOperation implements IOperation{
    @Override
    public void work(BookList bookList) {

        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}


