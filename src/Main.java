import test.BookList;
import users.AdminUser;
import users.NormalUser;
import users.User;

import java.util.Scanner;

public class Main {
    public static User login(){
        System.out.println("请输入姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("请输入你的身份：1-->管理员 0-->普通用户");
        int who  = scanner.nextInt();
        if(who == 1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }

    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();

        while(true) {
            // 根据菜单的选项 调用合适的方法
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }

    }
}
