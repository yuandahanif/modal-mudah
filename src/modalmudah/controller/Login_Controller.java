/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author yuan
 */
public class Login_Controller implements Initializable {

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
    private PasswordField tf_passwtf_login_passwordord1;
    @FXML
    private Button b_login_masuk;
    @FXML
    private VBox vb_pilihan;
    @FXML
    private Button b_p_masuk;
    @FXML
    private Button b_p_daftar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
    }

}
