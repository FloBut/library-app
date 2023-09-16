//Creeaza clasa Library
//
//Atribute
//booksList - o lista cu cartile din biblioteca
public class Library {
    private Book[] books;
    private int numberOfBooks;

    public Library(int size) {
        this.books = new Book[size];
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public boolean isBookInList(String ISBNCode) {
    //verific daca cartea este in biblioteca
        //parcurg lista de carti si daca codul primit ca parametru  este in lista si lista nu etse nula returnez true
        // metoda va returna false daca cartea nu este in lista
        for (int i = 0; i < numberOfBooks; i++) {
            if (books[i] != null && ISBNCode.equals(books[i].getISBNCode())) {
                return true;
            }
        }
        return false;
    }
    public int findIndexOfBook(String ISBNCode) {
        //daca gasesc in lista de carti codul ISBN trimis ca parametru metodei atunci returnez indexul
        //parcurg lista de carti si verific daca codul este in lista returnez parametrul
        //daca nu este in lista returnez -1
        for (int i = 0; i < numberOfBooks; i++) {
            if (ISBNCode.equals(books[i].getISBNCode())) {
                return i;
            }
        }
        return -1;
    }
        public Book findByISBNCode(String ISBNCode) {
            for (int i = 0; i < numberOfBooks; i++) {
                if(ISBNCode.equals(books[i].getISBNCode())) {
                    return books[i];
                }
            }
            return null;
        }
    //acesta metoda va sterge o carte din bibliteca avand ca parametru indexul la care se afla cartea
    public void deleteBook(int startIndex) {
        for (int i = startIndex; i < numberOfBooks; i++) {
            books[i] = books[ i + 1];
        }
        //actualizam numarul de carti din sistem
        numberOfBooks--;
    }
    //adaug o carte in lista de carti
    public void addBookInList(Book book) {
        books[numberOfBooks] = book;
    }

    //afisez toate cartile din lista de carti
    public void listBooks() {
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println(books[i]);
        }
    }

}
