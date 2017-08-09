package model;

/**
 * Created by AsusIT on 03.08.2017.
 */
public class User {
    private int idUser;
    private String nameUser;
    private String password;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {}

    public User(String nameUser, String password) {
        this.nameUser = nameUser;
        this.password = password;
    }

    @Override
    public String toString() {
        return "name - " + nameUser + "password - " + password;
    }
}
