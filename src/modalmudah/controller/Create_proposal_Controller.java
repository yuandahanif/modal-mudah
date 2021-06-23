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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modalmudah.helper.xstream;
import modalmudah.model.Kategori;
import modalmudah.model.Proposal;

/**
 * FXML Controller class
 *
 * @author yuan
 */
public class Create_proposal_Controller implements Initializable {

    private xstream<ArrayList<Proposal>> dataXml;
    private ArrayList<Proposal> proposalArray;
    private Proposal proposal;

    @FXML
    private ChoiceBox cb_kategori;

    @FXML
    private TextField tf_ukm_nama, tf_ukm_jumlah_modal, tf_dataDiri_nama, tf_dataDiri_noIdentitas, tf_dataDiri_kontak;

    @FXML
    private TextArea ta_ukm_deskripsi, ta_dataDiri_alamat;

    @FXML
    private Button b_submit, b_clear;

    @FXML
    private void handleSubmitButtonAction(ActionEvent event) {
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
        } catch (NumberFormatException e) {

        }
        System.out.println(proposalArray.toString());
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
//        kategori_Cb.setDisable(false);
//        namaUkm.setText("");
//        deskripsi.setText("");
//        jumlahModal.setText("");
//        fileProposal.setText("");
//        dataDiri_nama.setText("");
//        dataDiri_noIdentitas.setText("");
//        dataDiri_alamat.setText("");
//        dataDiri_noIdentitas.setDisable(false);
//        proposalIndex = 0;
//        updatedProposal = null;
//        ubayhBeneran.setDisable(true);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_kategori.getItems().addAll(Arrays.asList(Kategori.values()));

        proposalArray = new ArrayList<>();
        dataXml = new xstream(Proposal.XML_FILE_NAME, proposalArray);
        proposalArray = dataXml.loadXml();
        System.out.println(proposalArray.toString());
    }

}
