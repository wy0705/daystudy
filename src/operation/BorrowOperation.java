package operation;

import test.Book;
import test.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        System.out.println("请输入要借阅的图书的名字:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();


        for (int i = 0; i <bookList.getUsedSize(); i++) {

            Book book = bookList.getBooks(i);

            if(name.equals(book.getName()) && book.isBorrowed()==false) {
                //找到了就借阅
                book.setBorrowed(true);
                return ;
            }
        }
        System.out.println("借阅失败，没有此书 ，或此书已被借出");
    }
}

