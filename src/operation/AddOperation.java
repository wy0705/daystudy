package operation;

import test.Book;
import test.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = scanner.nextLine();
        System.out.println("请输入作者：");
        String author = scanner.nextLine();
        System.out.println("请输入类别：");
        String type = scanner.nextLine();
        System.out.println("请输入价格：");
        int price  = scanner.nextInt();

        for (int i = 0; i <bookList.getUsedSize() ; i++) {
            Book book = bookList.getBooks(i);
            if(name.equals(book.getName())){
                System.out.println("书架存在这本书，不能重复添加！");
                return;
            }
        }

        int currentSize = bookList.getUsedSize();

        Book book = new Book(name,author,price,type);

        bookList.setBooks(currentSize,book);

        bookList.setUsedSize(currentSize+1);

        System.out.println("增加成功！");
    }
}

