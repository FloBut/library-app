//Creeaza clasa User, care va reprezenta un utilizator al aplicatiei de gestiune
//
//Atribute
//Nume
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
