package operation;

import test.Book;
import test.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        System.out.println("请输入要归还的图书的名字:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();


        for (int i = 0; i <bookList.getUsedSize(); i++) {

            Book book = bookList.getBooks(i);

            if(name.equals(book.getName())) {
                //找到了就归还
                book.setBorrowed(false);
                System.out.println("归还成功！");
                return ;
            }
        }
        System.out.println("归还失败，没有此书！");
    }
}
