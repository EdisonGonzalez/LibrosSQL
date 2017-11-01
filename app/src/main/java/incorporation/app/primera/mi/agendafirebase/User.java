package incorporation.app.primera.mi.agendafirebase;

/**
 * Created by LENOVO on 18/10/2017.
 */

public class User {
    private String name, author, presta, phone;
    private String uid;

    public User(String uid, String name, String author, String presta, String phone) {
        this.uid = uid;
        this.name = name;
        this.author = author;
        this.presta = presta;
        this.phone = phone;
    }

    public User() {//este lo pide firebase
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPresta() {
        return presta;
    }

    public void setPresta(String presta) {
        this.presta = presta;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    /*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}*/
}