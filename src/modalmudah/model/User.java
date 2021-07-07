/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.model;

/**
 *
 * @author yuan
 */
public class User {

    private final String no_id;
    private String email;
    private String name;
    private String password;

    public static final String XML_FILE_NAME = "user_data";

    public User(String no_id, String email, String name, String password) {
        this.no_id = no_id;
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getNo_id() {
        return no_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
