package test;

public class BookList {

    private Book[] books = new Book[100];
    private int usedSize;


    public BookList(){

        //默认有四本书

        books[0] = new Book("西游记","吴承恩",10,"小说" );
        books[1] = new Book("水浒传","施耐庵",20,"小说" );
        books[2] = new Book("红楼梦","曹雪芹",10,"小说" );
        books[3] = new Book("三国演义","罗贯中",10,"小说" );
        this.usedSize  = 4;
    }

    public Book getBooks(int pos) {
        return this.books[pos];
    }

    public void setBooks(int pos,Book book) {
        //默认放到顺序表的最后
        this.books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
