/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modalmudah.helper.xstream;
import modalmudah.model.Proposal;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Modality;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author yuan
 */
public class TableView_proposal_Controller implements Initializable {

    private ArrayList<Proposal> proposalArray;
    private xstream<ArrayList<Proposal>> dataXml;
    ObservableList<Proposal> dataProposal;

    int proposalIndex;
    Proposal updatedProposal = null;

    @FXML
    private TableView proposal_T;
    @FXML
    private TableColumn<?, ?> namaUKM_Tc;
    @FXML
    private TableColumn<?, ?> pemilikUKM_Tc;
    @FXML
    private TableColumn<?, ?> modalUKM_Tc;
    @FXML
    private TableColumn<?, ?> kategori_Tc;
    @FXML
    private Button hapus;
    @FXML
    private Button ubah;

    //    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
        } catch (NumberFormatException e) {
        }
    }

    @FXML
    private void handleTableClick(MouseEvent event) {
        hapus.setDisable(false);
        ubah.setDisable(false);
    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(modalmudah.ModalMudah.class.getResource("/modalmudah/view/" + "update_proposal_view.fxml"));
        //Praktikum1 diganti dengan nama file controller untuk FXML yang kedua
        // FXML2 diganti dengan FXML yang kedua

        Stage dialogStage = new Stage();
        dialogStage.setTitle("testing");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(loader.load());
        dialogStage.setScene(scene);
        // Show the dialog and wait until the user closes it
        dialogStage.showAndWait();
    }

    //tombol hapus
    @FXML
    private void handleHapusButtonAction(ActionEvent event) {
        ObservableList<Proposal> P, allProposals;
        allProposals = proposal_T.getItems();
        P = proposal_T.getSelectionModel().getSelectedItems();

        // hapus dari tabel
        P.forEach(allProposals::remove);
        proposal_T.getSelectionModel().select(null);

        // save to xml
        ArrayList<Proposal> dataProposalbaru = new ArrayList<>(allProposals);
        dataXml.saveToXML(dataProposalbaru);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        dataXml = new xstream(Proposal.XML_FILE_NAME, proposalArray);
        proposalArray = dataXml.loadXml();
        dataProposal = observableArrayList(proposalArray);

        namaUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama_UKM"));
        modalUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("jumlah_modal_UKM"));
        pemilikUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategori_Tc.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        proposal_T.setItems(dataProposal);
    }

}
