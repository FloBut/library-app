// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Title1", "Author1", "00001", 5, 0);
        Book book2 = new Book("Title2", "Author2", "00002", 3, 1);
        Book book3 = new Book("Title3", "Author3", "00003", 6, 2);
        Book[] books = {book1, book2};
       Library library = new Library(20);
       Admin admin = new Admin("John", library);
    }
}