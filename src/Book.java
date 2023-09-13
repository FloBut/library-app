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
    private String autor;
    private String ISBNCode;
    private int totalNumberOfCopies;
    private int borrowedNumberOfCopies;

    public Book(String title, String autor, String ISBNCode, int totalNumberOfCopies, int borrowedNumberOfCopies) {
        this.title = title;
        this.autor = autor;
        this.ISBNCode = ISBNCode;
        this.totalNumberOfCopies = totalNumberOfCopies;
        this.borrowedNumberOfCopies = borrowedNumberOfCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
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
                ", autor='" + autor + '\'' +
                ", ISBNCode='" + ISBNCode + '\'' +
                ", totalNumberOfCopies=" + totalNumberOfCopies +
                ", borrowedNumberOfCopies=" + borrowedNumberOfCopies +
                '}';
    }
}
