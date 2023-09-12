import java.util.Arrays;



public class Client extends User {
    private String[] borrowedBooksCode;
    int noBorrowBooks;

    public Client(String name) {
        super(name);
        noBorrowBooks = 0;
    }

    //isBookAvailable() - Va cauta o carte in biblioteca dupa ISBNCode si va afisa daca este sau nu disponibila pentru imprumut
    public boolean isBookAvailable(Library library, String ISBNCode) {
        //parcurg lista de carti a bibliotecii si verific daca codul ISBN primit ca parametru
        // nu se gaseste in lista de coduri din librarie atunci returnez false
        for (int i = 0; i < library.getBooks().length; i++) {
            if (!(ISBNCode.equals(library.getBooks()[i].getISBNCode()))) {//accesez fiecare cod ISBN corespunzator fiecarei carti din biblioteca
                return false;
            }
        }
       return true;
    }
    // viewAvailableBooks() - va afisa in consola toate cartile disponibile din biblioteca (adica cartile
    //// care au borrowedNumberOfBooks mai mic decat totalNumberOfBooks)

    public void viewAvailableBooks(Library library) {
        for (int i = 0; i < library.getBooks().length; i++) {
            if (library.getBooks()[i].getTotalNumberOfCopies() > library.getBooks()[i].getBorrowedNumberOfCopies()) {
                System.out.println(library.getBooks()[i]);
            }
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
                   borrowedBooksCode[noBorrowBooks++] = ISBNCode;
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
                for (int j = 0; j < noBorrowBooks; j++) {
                    if (ISBNCode.equals(borrowedBooksCode[j])) {
                        for (int k = j; k < noBorrowBooks; k++) {
                            borrowedBooksCode[j] = borrowedBooksCode[k + 1];
                        }
                        noBorrowBooks--;
                    }
                }
                //cum fac sa scad numarul de copii de cart imprumutate??
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
