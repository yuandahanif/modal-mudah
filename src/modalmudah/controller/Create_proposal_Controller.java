/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import modalmudah.helper.ImageHelper;
import modalmudah.helper.xstream;
import modalmudah.model.Kategori;
import modalmudah.model.Proposal;
import modalmudah.model.User;

/**
 * FXML Controller class
 *
 * @author yuan
 */
public class Create_proposal_Controller implements Initializable {

    Alert warning = new Alert(Alert.AlertType.WARNING);
    private xstream<ArrayList<Proposal>> dataXml;
    private ArrayList<Proposal> proposalArray = new ArrayList<>();
    private xstream<User> userXml;
    private User user = new User();

    @FXML
    private ChoiceBox cb_kategori;

    @FXML
    private TextField tf_ukm_nama, tf_ukm_jumlah_modal, tf_dataDiri_nama, tf_dataDiri_noIdentitas, tf_dataDiri_kontak;

    @FXML
    private TextArea ta_ukm_deskripsi, ta_dataDiri_alamat;

    @FXML
    private Button b_submit, b_clear;

    private void clearFormInput() {
//        tf_dataDiri_noIdentitas.setText("");
//        tf_dataDiri_nama.setText("");
        ta_dataDiri_alamat.setText("");
        tf_dataDiri_kontak.setText("");
        tf_ukm_nama.setText("");
        ta_ukm_deskripsi.setText("");
        tf_ukm_jumlah_modal.setText("");
    }

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
        if (cb_kategori.getValue() == null) {
            warning.setContentText("Kategori tidak boleh kosong");
            warning.showAndWait();
        } else {
            // validasi
            if (notEmptyValue(tf_dataDiri_noIdentitas.getText()) && notEmptyValue(tf_dataDiri_nama.getText()) && notEmptyValue(tf_ukm_nama.getText())) {
                try {
                    Kategori ktg = Kategori.valueOf(cb_kategori.getValue().toString());
                    proposalArray.add(new Proposal(tf_dataDiri_noIdentitas.getText(),
                            tf_dataDiri_nama.getText(),
                            ta_dataDiri_alamat.getText(),
                            tf_dataDiri_kontak.getText(),
                            tf_ukm_nama.getText(),
                            ta_ukm_deskripsi.getText(),
                            Integer.parseInt(tf_ukm_jumlah_modal.getText()),
                            ktg));
                    dataXml.saveToXML(proposalArray);
                    clearFormInput();
                } catch (NumberFormatException e) {
                    warning.setContentText("Jumlah modal harus angka");
                    warning.showAndWait();
                }
            } else {
                warning.setContentText("Semua input harus diisi.");
                warning.showAndWait();
            }
        }
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        clearFormInput();
    }

    private boolean notEmptyValue(String input) {
        return !input.equals("");
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        warning.setTitle("Input error");
        b_submit.setGraphic(new ImageView(ImageHelper.getImage("plus.png")));
        b_clear.setGraphic(new ImageView(ImageHelper.getImage("trash.png")));

        cb_kategori.getItems().addAll(Arrays.asList(Kategori.values()));

        userXml = new xstream(User.XML_AUTH_FILE_NAME, user);
        user = userXml.loadXml();
        dataXml = new xstream(Proposal.XML_FILE_NAME, proposalArray);
        proposalArray = dataXml.loadXml();

        tf_dataDiri_noIdentitas.setDisable(true);
        tf_dataDiri_noIdentitas.setText(user.getNo_id());

        tf_dataDiri_nama.setDisable(true);
        tf_dataDiri_nama.setText(user.getName());
    }

}
