import java.util.Arrays;
//Creeaza clasa Client, care extinde User
//
//Atribute
//borrowedBooksCodes - lista ISBNCode-urilor cartilor imprumutate de client
//Metode
//isBookAvailable() - Va cauta o carte in biblioteca dupa ISBNCode si va afisa daca este sau nu disponibila pentru imprumut
//viewAvailableBooks() - va afisa in consola toate cartile disponibile din biblioteca (adica cartile care au
// borrowedNumberOfBooks mai mic de cat totalNumberOfBooks)
//borrowBook() - va imprumuta o carte din biblioteca dupa ISBNCode, ceea ceva avea doua efecte:
// Codul cartii imprumutate va fi adaugat in lista de coduri a clientului si In acelasi timp,
// cartii cu acelasi ISBNCode din lista de carti din librarie ii va fi incrementat atributul borrowedNumberOfCopies cu 1.
// Atentie! Operatia de imprumutare nu va fi posibila pentru o carte daca borrowedNumberOfCopies este egal cu totalNumberOfCopies
//returnBook() - va returna o carte in biblioteca dupa ISBNCode, ceea ce va avea doua efecte:
// Codul ISBNCode va disparea din lista de coduri ale clientului si In acelasi timp, cartii cu acel ISBNCode din lista de carti a bibliotecii ii va fi decrementat atributul borrowedNumberOfCopies cu 1. Atentie: toate metodele vor trebui sa primeasca ca parametru in plus o biblioteca


public class Client extends User {
    private  String[] borrowedBooksCode;
    int noOfBorrowedBooks;

    public Client(String name, Library library) {
        super(name, library);
        this.borrowedBooksCode = new String[10];
        this.noOfBorrowedBooks = 0;
    }

    public String[] getBorrowedBooksCode() {
        return borrowedBooksCode;
    }

    public void setBorrowedBooksCode(String[] borrowedBooksCode) {
        this.borrowedBooksCode = borrowedBooksCode;
    }

    public int getNoOfBorrowedBooks() {
        return noOfBorrowedBooks;
    }

    public void setNoOfBorrowedBooks(int noOfBorrowedBooks) {
        this.noOfBorrowedBooks = noOfBorrowedBooks;
    }

    //isBookAvailable() - Va cauta o carte in biblioteca dupa ISBNCode si va afisa daca este sau nu disponibila pentru imprumut
    public boolean isBookAvailable(String ISBNCode) throws Exception {
    // viewAvailableBooks() - va afisa in consola toate cartile disponibile din biblioteca (adica cartile
    //// care au borrowedNumberOfBooks mai mic decat totalNumberOfBooks)
       return getLibrary().isBookInList(ISBNCode);
    }

    public void viewAvailableBooks() {//aici pot returna lista de carti disponibila si sa ma folosesc in met borrowbook
        Book[] books = getLibrary().getBooks();
        for (int i = 0; i < getLibrary().getBooks().length; i++) {

        }
    }

    // Atentie! Operatia de imprumutare nu va fi posibila pentru o carte daca borrowedNumberOfCopies este egal cu totalNumberOfCopies
    //borrowBook() - va imprumuta o carte din biblioteca dupa ISBNCode, ceea ceva avea doua efecte:
    // Codul cartii imprumutate va fi adaugat in lista de coduri a clientului si
    // In acelasi timp, cartii cu acelasi ISBNCode din lista de carti din librarie ii va fi incrementat
    // atributul borrowedNumberOfCopies cu 1.

    public boolean borrowBook(Library library, String ISBNCode) {
        // daca cartea cu ISBNCode primit ca parametru este disponibila
        // atunci verific daca pentru acea carte am numarul de copii mai mic decat numarul de carti imprumutate nu merg mai departe
        // altfel pot imprumuta cartea si fac si pasii urmatori
           // cum fac sa nu mai parcurg lista de carti ci doar pentru cartea care este disponibila sa verific conditia?
        int flag = 0;
           for (int i = 0; i < library.getBooks().length; i++) {
               if (ISBNCode.equals(library.getBooks()[i].getISBNCode()) &&
                       (library.getBooks()[i].getTotalNumberOfCopies() > library.getBooks()[i].getBorrowedNumberOfCopies())) {
                   borrowedBooksCode[noOfBorrowedBooks++] = ISBNCode;
                   //cum fac sa cresc numarul de carti imprumutate
                   //library.setBooks(library.getBooks().getBorrowedNumberOfCopies());
                   flag = 1;
               }

           }
           if (flag == 0) {
               return false;
           }
         return true;
    }

    //returnBook() - va returna o carte in biblioteca dupa ISBNCode, ceea ce va avea doua efecte:
    // Codul ISBNCode va disparea din lista de coduri ale clientului si
    // In acelasi timp, cartii cu acel ISBNCode din lista de carti a bibliotecii ii va fi decrementat atributul
    // borrowedNumberOfCopies cu 1.
// Atentie: toate metodele vor trebui sa primeasca ca parametru in plus o biblioteca
    public boolean returnBook(Library library, String ISBNCode) {
        int flag  = 0;
        for (int i = 0; i < library.getBooks().length; i++) {
            if (ISBNCode.equals(library.getBooks()[i].getISBNCode())) {
                //parcurg lista de carti imprumutate si daca codul primit ca parametru se gaseste in aceasta lista
                //atunci suprascriu acel cod cu urmatoarele din lista si scad numarul de carti imprumutate
                for (int j = 0; j < noOfBorrowedBooks; j++) {
                    if (ISBNCode.equals(borrowedBooksCode[j])) {
                        for (int k = j; k < noOfBorrowedBooks; k++) {
                            borrowedBooksCode[j] = borrowedBooksCode[k + 1];
                        }
                        noOfBorrowedBooks--;
                    }
                }
                //cum fac sa scad numarul de copii de carti imprumutate??
                //library.setBooks(library.getBooks()[i].getBorrowedNumberOfCopies()-1);
                flag = 1;
            }
        }
        if (flag == 0) {
            return false;
        }
        return true;

    }

}
