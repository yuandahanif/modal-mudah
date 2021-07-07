/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import modalmudah.helper.xstream;
import modalmudah.model.User;

/**
 * FXML Controller class
 *
 * @author yuan
 */
public class Login_Controller implements Initializable {

    Alert warning = new Alert(Alert.AlertType.WARNING);
    private ArrayList<User> userArray = new ArrayList<>();
    private xstream<ArrayList<User>> dataXml;
    private xstream<User> userXml;

    @FXML
    private Label tf_title;
    @FXML
    private VBox vb_daftar;

    @FXML
    private TextField tf_daftar_id;
    @FXML
    private TextField tf_daftar_nama;
    @FXML
    private TextField tf_daftar_email;
    @FXML
    private PasswordField tf_daftar_password;
    @FXML
    private Button b_daftar_daftar;
    @FXML
    private VBox vb_masuk;

    @FXML
    private TextField tf_login_email;
    @FXML
    private PasswordField tf_login_password;
    @FXML
    private Button b_login_masuk;

    @FXML
    private VBox vb_pilihan;
    @FXML
    private Button b_p_masuk, b_login_kembali;
    @FXML
    private Button b_p_daftar, b_daftar_kembali;

    public void setOnLogin(AnchorPane t, Consumer<AnchorPane> callback) {
        // saat user login
        b_login_masuk.setOnAction((ActionEvent event) -> {
            String email = tf_login_email.getText(),
                    password = tf_login_password.getText();

            if (notEmptyValue(email) && notEmptyValue(password)) {
                User user = getAccount(email, password);
                if (null != user) {
                    // simpan sesi login
                    userXml.saveToXML(user);
                    callback.accept(t);
                } else {
                    warning.setContentText("email atau password salah");
                    warning.showAndWait();
                }
            } else {
                warning.setContentText("semua field harus di isi!");
                warning.showAndWait();
            }
        });
    }

    private boolean notEmptyValue(String input) {
        return !input.equals("");
    }

    private void moveLoginToPane() {
        warning.setTitle("Masuk input error");
        tf_title.setText("Masuk");
        vb_pilihan.setVisible(false);
        vb_masuk.setVisible(true);
    }

    private User getAccount(String email, String password) {
        for (User user : userArray) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // load data xml
        dataXml = new xstream(User.XML_FILE_NAME, userArray);
        userArray = dataXml.loadXml();

        // user memilih daftar
        b_p_daftar.setOnAction((ActionEvent event) -> {
            warning.setTitle("Daftar input error");
            tf_title.setText("Daftar");
            vb_pilihan.setVisible(false);
            vb_daftar.setVisible(true);
        });
        b_daftar_kembali.setOnAction((event) -> {
            tf_title.setText("Selamat datang di ModalMudah");
            vb_pilihan.setVisible(true);
            vb_daftar.setVisible(false);
        });

        // user memilih login
        b_p_masuk.setOnAction((ActionEvent event) -> {
            userXml = new xstream(User.XML_AUTH_FILE_NAME, new User());
            moveLoginToPane();
        });

        b_login_kembali.setOnAction((event) -> {
            tf_title.setText("Selamat datang di ModalMudah");
            vb_pilihan.setVisible(true);
            vb_masuk.setVisible(false);
        });

        // saat user daftar
        b_daftar_daftar.setOnAction((ActionEvent event) -> {

            String id = tf_daftar_id.getText(),
                    nama = tf_daftar_nama.getText(),
                    email = tf_daftar_email.getText(),
                    password = tf_daftar_password.getText();
            if (notEmptyValue(id) && notEmptyValue(nama) && notEmptyValue(email) && notEmptyValue(password)) {
                User u = new User(id, email, nama, password);
                userArray.add(u);
                dataXml.saveToXML(userArray);

                vb_daftar.setVisible(false);

                moveLoginToPane();
            } else {
                warning.setContentText("semua field harus di isi!");
                warning.showAndWait();
            }
        });
    }
}
