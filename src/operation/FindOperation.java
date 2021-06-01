package operation;

import test.Book;
import test.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList booklist){
        System.out.println("请输入要查找的书名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        for (int i = 0; i <booklist.getUsedSize() ; i++) {
            Book book = booklist.getBooks(i);
            if(name.equals(book.getName())){
                System.out.println("找到此书入下：");
                System.out.println(book);
                return ;
            }
        }

        System.out.println("没有这本书！");
    }
}

