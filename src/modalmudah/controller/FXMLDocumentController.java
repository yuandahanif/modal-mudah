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
    private Button submit, hapus, ubah;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        //tableMahasiswa.getSelectionModel().getSelectedItem(); pilih item di table.
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
    }

}
