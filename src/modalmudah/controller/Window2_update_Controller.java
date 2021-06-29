/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modalmudah.helper.xstream;
import modalmudah.model.Proposal;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Window2_update_Controller implements Initializable {

    private int updateProposalIndex;
    private ArrayList<Proposal> proposalArrayList;
    private xstream<ArrayList<Proposal>> dataXml;
    private Proposal proposal;

    @FXML
    private ChoiceBox cb_kategori;

    @FXML
    private TextField tf_ukm_nama, tf_ukm_jumlah_modal, tf_dataDiri_nama, tf_dataDiri_noIdentitas, tf_dataDiri_kontak;

    @FXML
    private TextArea ta_ukm_deskripsi, ta_dataDiri_alamat;

    @FXML
    private Button b_submit, b_clear;

    private void clearFormInput() {
        tf_dataDiri_noIdentitas.setText("");
        tf_dataDiri_nama.setText("");
        ta_dataDiri_alamat.setText("");
        tf_dataDiri_kontak.setText("");
        tf_ukm_nama.setText("");
        ta_ukm_deskripsi.setText("");
        tf_ukm_jumlah_modal.setText("");
    }

    private void initFormValue() {
        tf_dataDiri_noIdentitas.setText(proposal.getId());
        tf_dataDiri_noIdentitas.setDisable(true);

        tf_dataDiri_nama.setText(proposal.getNama());
        ta_dataDiri_alamat.setText(proposal.getAlamat());
        tf_dataDiri_kontak.setText(proposal.getKontak());
        tf_ukm_nama.setText(proposal.getNama_UKM());
        ta_ukm_deskripsi.setText(proposal.getDeskripsi_UKM());
        tf_ukm_jumlah_modal.setText(String.valueOf(proposal.getJumlah_modal_UKM()));

        cb_kategori.setValue(proposal.getKategori());
        cb_kategori.setDisable(true);
    }

    public void setProposalArrayList(ArrayList<Proposal> proposalArrayList) {
        this.proposalArrayList = proposalArrayList;
    }

    public void setProposal(Proposal proposal, int index) {
        updateProposalIndex = index;
        this.proposal = proposal;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFormValue();

        // pas clear di klik
        b_clear.setOnAction((ActionEvent event) -> {
            clearFormInput();
            b_clear.setDisable(true);
        });

        // pas submit di klik
        b_submit.setOnAction((ActionEvent event) -> {
            // TODO: hayo updatenya gimana :v
            System.out.println("update");
        });
    }

}
