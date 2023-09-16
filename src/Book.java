//Atribute
//Title
//Author
//ISBNCode
//totalNumberOfCopies
//borrowedNumberOfCopies
//Metode
//Doar getteri si setteri
//Creeaza clasa Library
//
//Atribute
//booksList - o lista cu cartile din biblioteca


public class Book {
    private String title;
    private String author;
    private String ISBNCode;
    private int totalNumberOfCopies;
    private int borrowedNumberOfCopies;

    public Book(String title, String autor, String ISBNCode, int totalNumberOfCopies, int borrowedNumberOfCopies) {
        this.title = title;
        this.author = autor;
        this.ISBNCode = ISBNCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String autor) {
        this.author = autor;
    }

    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }
    public boolean isAvailable() {
        return totalNumberOfCopies > borrowedNumberOfCopies;
    }

    public int getTotalNumberOfCopies() {
        return totalNumberOfCopies;
    }

    public void setTotalNumberOfCopies(int totalNumberOfCopies) {
        this.totalNumberOfCopies = totalNumberOfCopies;
    }

    public int getBorrowedNumberOfCopies() {
        return borrowedNumberOfCopies;
    }

    public void setBorrowedNumberOfCopies(int borrowedNumberOfCopies) {
        this.borrowedNumberOfCopies = borrowedNumberOfCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autor='" + author + '\'' +
                ", ISBNCode='" + ISBNCode + '\'' +
                ", totalNumberOfCopies=" + totalNumberOfCopies +
                ", borrowedNumberOfCopies=" + borrowedNumberOfCopies +
                '}';
    }
}
