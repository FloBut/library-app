public class Admin extends User {

//Creeaza clasa Admin, care extinde User
// Atentie: toate metodele vor trebui sa primeasca ca parametru in plus o biblioteca

    public Admin(String name, Library library) {
        super(name, library);
    }

///addBook() - va adauga o carte in lista de carti a bilbiotecii.
        // Daca cartea cu acel ISBNCode exista deja in lista de carti a bibliotecii,
       // atunci doar i se va incrementa valoarea atributului numberOfCopies
    public boolean addBook(Book newBook) {
        //daca cartea este in lista atunci o voi salva intr o variabila te tip Book
        Book booInList = getLibrary().findByISBNCode(newBook.getISBNCode());
        //cresc numarul de copii
        if (booInList != null) {
            booInList.setTotalNumberOfCopies(booInList.getTotalNumberOfCopies() + 1);
            return true;
        }
    //daca cartea nu exista o adaug in biblioteca
        else {
            getLibrary().addBookInList(newBook);
            newBook.setTotalNumberOfCopies(1);
            return true;
        }
    }

    //deleteBook() - Va fi o metoda supraincarcata.
    // Prima varianta va primi doar un paramentru, ISBNCode si va sterge de tot cartea din lista de carti a bibliotecii.

    public void deleteBook(String ISBNCode) throws Exception {
        //salvez indexul la care se afla cartea pe care am gasit - o dupa ISBNCode intr o variabila
        int foundeIndex = getLibrary().findIndexOfBook(ISBNCode);
        //daca variabila are valoarea -1 atunci cartea nu se afla in lista si araunc o execptie
        if (foundeIndex == -1) {
            throw new Exception("book does not exist");
        }
        //daca variabila imi returneaza indexul atunci sterg de la acel index cartea
        getLibrary().deleteBook(foundeIndex);

        if (getLibrary().isBookInList(ISBNCode)) {
            int index = getLibrary().findIndexOfBook(ISBNCode);
            //mutam elementele de dupa cartea gasita cu o pozitie mai la stanga
            for (int i = index; i < getLibrary().getNumberOfBooks() - 1; i++) {
                getLibrary().getBooks()[i] = getLibrary().getBooks()[i + 1];
            }
            //actualizam nr de carti diponibile
            getLibrary().setNumberOfBooks(getLibrary().getNumberOfBooks() - 1);
        } else {
            throw new Exception("Cartea nu exista in bibliteca");
        }
    }
        public void deleteBook(String ISBNCode, int numberOfCopiesDelete) throws Exception {
            Book book = getLibrary().findByISBNCode(ISBNCode);
            if (book == null) {
                throw new Exception("cartea nu exista");
            }
            if (book.getTotalNumberOfCopies() <= numberOfCopiesDelete) {
                throw new Exception("you can not delete this amaount of copies");
            }
            book.setTotalNumberOfCopies(book.getTotalNumberOfCopies() - numberOfCopiesDelete);
        }

    public void listAllBooks() {
        getLibrary().listBooks();
    }
    public void ListBookDetails(String ISBNCode) {
        if (getLibrary().isBookInList(ISBNCode)) {
            Book book = getLibrary().findByISBNCode(ISBNCode);
            System.out.println(book.toString());
        } else {
            System.out.println("Cartea nu exista in biblioteca");
        }
    }
    public void viewBorrowedBooks(Client client) {
        for (int i = 0; i < client.noOfBorrowedBooks; i++) {
            System.out.println(client.getBorrowedBooksCode()[i]);
        }
    }
}
// A doua varianta va primi doi paremetrii: ISBNCode si numarul de copii care se vor sterge.
//In acest caz, cartea nu va fi stearsa din lista de carti a bibliotecii,
// ci doar se va scadea din numarul total de copii al cartii, numarul de copii primit ca parametru
//    public void deleteBook(Library library, String ISBNCode, int noOfDeleteCopies) {
//        for (int i = 0; i < library.getBooks().length; i++) {
//            if (ISBNCode.equals(library.getBooks()[i].getISBNCode())) {
//                //library.setBooks(library.getBooks()[i].getTotalNumberOfCopies() - noOfDeleteCopies);
//            }
//        }
//    }
//    //listAllBooks() - va printa detaliile fiecarei carti din lista de carti a bibliotecii
//    public Library[] listAllBook(Library library) {
//       return new Library[]{library};
//    }
//    //listBookDetails() - Va printa detaliile unei singure carti din biblioteca, in functie de codul ISBNCode
//    public void listAllBook(Library library, String ISBNCode) {
//        for (int i = 0; i < library.getBooks().length; i++) {
//            if (ISBNCode.equals(library.getBooks()[i].getISBNCode())) {
//                System.out.println(library.getBooks()[i].toString());
//            }
//        }
//
//    }
//    //viewBorrowedBooks() - Va lista codurile ISBNCode ale cartilor imprumutate de un client, in functie de numele clientului primit ca parametru.
//    public void viewBorrowedBooks(Admin[] namesList, String name) {
//        for (int i = 0; i < namesList.length; i++) {
//            if (name.equals(namesList[i].getName())) {
//                //daca numele se gaseste in lista de nume ar trebui sa afisez lista de coduri pentru acel nume
//                //System.out.println(namesList[i].borrowedBooksCode);
//            }
//        }
//    }
