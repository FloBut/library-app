public class Admin extends User {

//Creeaza clasa Admin, care extinde User
// Atentie: toate metodele vor trebui sa primeasca ca parametru in plus o biblioteca

    public Admin(String name) {
        super(name);
    }
    String[] userlist;

///addBook() - va adauga o carte in lista de carti a bilbiotecii.
        // Daca cartea cu acel ISBNCode exista deja in lista de carti a bibliotecii,
       // atunci doar i se va incrementa valoarea atributului numberOfCopies
    public void addBook(Library library, String ISBNCode) {
        for (int i = 0; i < library.getBooks().length; i++) {
            if (ISBNCode.equals(library.getBooks()[i].getISBNCode())) {
                //library.setBooks(library.getBooks()[i].getTotalNumberOfCopies() + 1);
            } //daca cartea nu exista se va aduga in biblioteca
            // cum adaug cartea in lista de carti daca stiu ISBNCode?
        }

    }

    //deleteBook() - Va fi o metoda supraincarcata.
    // Prima varianta va primi doar un paramentru, ISBNCode si va sterge de tot cartea din lista de carti a bibliotecii.

    public void deleteBook(Library library, String ISBNCode) {
        for (int i = 0; i < library.getBooks().length; i++) {
            if (ISBNCode.equals(library.getBooks()[i].getISBNCode())) {
                for (int j = i; j < library.getBooks().length; i++) {
                    library.getBooks()[j] = library.getBooks()[j + 1];
                }
            }
        }
    }
    // A doua varianta va primi doi paremetrii: ISBNCode si numarul de copii care se vor sterge.
    //In acest caz, cartea nu va fi stearsa din lista de carti a bibliotecii,
    // ci doar se va scadea din numarul total de copii al cartii, numarul de copii primit ca parametru
    public void deleteBook(Library library, String ISBNCode, int noOfDeleteCopies) {
        for (int i = 0; i < library.getBooks().length; i++) {
            if (ISBNCode.equals(library.getBooks()[i].getISBNCode())) {
                //library.setBooks(library.getBooks()[i].getTotalNumberOfCopies() - noOfDeleteCopies);
            }
        }
    }
    //listAllBooks() - va printa detaliile fiecarei carti din lista de carti a bibliotecii
    public Library[] listAllBook(Library library) {
       return new Library[]{library};
    }
    //listBookDetails() - Va printa detaliile unei singure carti din biblioteca, in functie de codul ISBNCode
    public void listAllBook(Library library, String ISBNCode) {
        for (int i = 0; i < library.getBooks().length; i++) {
            if (ISBNCode.equals(library.getBooks()[i].getISBNCode())) {
                System.out.println(library.getBooks()[i].toString());
            }
        }

    }
    //viewBorrowedBooks() - Va lista codurile ISBNCode ale cartilor imprumutate de un client, in functie de numele clientului primit ca parametru.
    public void viewBorrowedBooks(Admin[] namesList, String name) {
        for (int i = 0; i < namesList.length; i++) {
            if (name.equals(namesList[i].getName())) {
                //daca numele se gaseste in lista de nume ar trebui sa afisez lista de coduri pentru acel nume
                //System.out.println(namesList[i].borrowedBooksCode);
            }
        }
    }
}
