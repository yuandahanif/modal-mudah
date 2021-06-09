/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import modalmudah.model.Proposal;

/**
 *
 * @author yuan
 */
public class FXMLDocumentController implements Initializable {

    ObservableList<Proposal> dataProposal = observableArrayList(new Proposal("22", "yuanda", "Bumi", "123456", "Kisaragi", "Evil company", 200000000, "tidak ada"));
    int proposalIndex;
    Proposal updatedProposal = null;

    @FXML
    private Label label;

    @FXML
    private TableView proposal_T;

    @FXML
    private TableColumn namaUKM_Tc;

    @FXML
    private TableColumn modalUKM_Tc;

    @FXML
    private TableColumn pemilikUKM_Tc;

    @FXML
    private TextField namaUkm, fileProposal, jumlahModal, dataDiri_nama, dataDiri_noIdentitas;

    @FXML
    private TextArea deskripsi, dataDiri_alamat;

    @FXML
    private Button submit, hapus, ubah, ubayhBeneran;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            dataProposal.add(new Proposal(dataDiri_noIdentitas.getText(),
                    dataDiri_nama.getText(),
                    dataDiri_alamat.getText(),
                    "0",
                    namaUkm.getText(),
                    deskripsi.getText(),
                    Integer.parseInt(jumlahModal.getText()),
                    fileProposal.getText()));
        } catch (NumberFormatException e) {
        }

    }

    @FXML
    private void handleHapusButtonAction(ActionEvent event) {
        ObservableList<Proposal> P, allProposals;
        allProposals = proposal_T.getItems();
        P = proposal_T.getSelectionModel().getSelectedItems();
        P.forEach(allProposals::remove);
        proposal_T.getSelectionModel().select(null);
    }

    @FXML
    private void handleUpdateButtonAction(ActionEvent event) {
        dataDiri_noIdentitas.setDisable(true);
        Proposal selectedP = (Proposal) proposal_T.getSelectionModel().getSelectedItem();

        namaUkm.setText(selectedP.getNama_UKM());
        deskripsi.setText(selectedP.getDeskripsi_UKM());
        jumlahModal.setText(String.valueOf(selectedP.getJumlah_modal_UKM()));
        fileProposal.setText(selectedP.getFile_UKM());
        dataDiri_nama.setText(selectedP.getNama());
        dataDiri_noIdentitas.setText(selectedP.getId());
        dataDiri_alamat.setText(selectedP.getAlamat());

        Proposal p = cariPropsal(selectedP);
        if (null != p) {
            updatedProposal = p;
            ubayhBeneran.setDisable(false);
        }
    }

    @FXML
    private void handleUbahButtonAction(ActionEvent event) {
        if (updatedProposal != null) {
            try {
                dataProposal.set(proposalIndex, new Proposal(updatedProposal.getId(),
                        dataDiri_nama.getText(),
                        dataDiri_alamat.getText(),
                        "0",
                        namaUkm.getText(),
                        deskripsi.getText(),
                        Integer.parseInt(jumlahModal.getText()),
                        fileProposal.getText()));
            } catch (NumberFormatException e) {
            }
        }
    }

    @FXML
    private void handleClearButtonAction(ActionEvent event) {
        namaUkm.setText("");
        deskripsi.setText("");
        jumlahModal.setText("");
        fileProposal.setText("");
        dataDiri_nama.setText("");
        dataDiri_noIdentitas.setText("");
        dataDiri_alamat.setText("");
        dataDiri_noIdentitas.setDisable(false);
        proposalIndex = 0;
        updatedProposal = null;
        ubayhBeneran.setDisable(true);
    }

    @FXML
    private void handleTableClick(MouseEvent event) {
        hapus.setDisable(false);
        ubah.setDisable(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        namaUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama_UKM"));
        modalUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("jumlah_modal_UKM"));
        pemilikUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama"));
        proposal_T.setItems(dataProposal);

        hapus.setDisable(true);
        ubah.setDisable(true);
        ubayhBeneran.setDisable(true);
    }

    private Proposal cariPropsal(Proposal p) {
        Proposal retP = null;
        proposalIndex = dataProposal.indexOf(p);

        for (Proposal proposal : dataProposal) {
            if (proposal.getId().equals(p.getId())) {
                retP = proposal;
            }
        }
        return retP;
    }
}
