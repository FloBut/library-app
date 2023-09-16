//Creeaza clasa User, care va reprezenta un utilizator al aplicatiei de gestiune
//
//Atribute
//Nume
public class User {
    private String name;
    private Library library;

    public User(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Library getLibrary() {
        return library;
    }
    public void setLibrary(Library library) {
        this.library = library;
    }
}
