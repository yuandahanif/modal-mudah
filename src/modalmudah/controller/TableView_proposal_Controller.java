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
    
    //tombol hapus
    @FXML
    private void handleHapusButtonAction(ActionEvent event) {
        ObservableList<Proposal> P, allProposals;
        allProposals = proposal_T.getItems();
        P = proposal_T.getSelectionModel().getSelectedItems();
        
        P.forEach(allProposals::remove);
        proposal_T.getSelectionModel().select(null);
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
        System.out.println(dataProposal.toString());

        namaUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama_UKM"));
        modalUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("jumlah_modal_UKM"));
        pemilikUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategori_Tc.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        proposal_T.setItems(dataProposal);
    }

}
