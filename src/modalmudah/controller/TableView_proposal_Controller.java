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
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modalmudah.model.Proposal;

/**
 *
 * @author user
 */
public class TableView_proposal_Controller implements Initializable{
    
    XYChart.Series<String, Integer> dataProposalUntukBC = new XYChart.Series<>();
    Proposal updatedProposal = null;
    ObservableList<Proposal> dataProposal = observableArrayList(new Proposal());
    int proposalIndex;
    
    @FXML
    private TextField tf_ukm_nama, tf_ukm_jumlah_modal, tf_dataDiri_nama, tf_dataDiri_noIdentitas, tf_dataDiri_kontak;
    
    @FXML
    private TextArea ta_ukm_deskripsi, ta_dataDiri_alamat;
    
    @FXML
    private TableView proposal_T;

    @FXML
    private ChoiceBox cb_kategori;
    
    @FXML
    private TableColumn namaUKM_Tc;

    @FXML
    private TableColumn modalUKM_Tc;

    @FXML
    private TableColumn pemilikUKM_Tc;

    @FXML
    private TableColumn kategori_Tc;
    
    
    //tombol hapus
    @FXML
    private void handleHapusButtonAction(ActionEvent event) {
        ObservableList<Proposal> P, allProposals;
        allProposals = proposal_T.getItems();
        P = proposal_T.getSelectionModel().getSelectedItems();
        P.forEach(allProposals::remove);
        proposal_T.getSelectionModel().select(null);
    }
    
//    @FXML
//    private void handleUpdateButtonAction(ActionEvent event) {
//        tf_dataDiri_noIdentitas.setDisable(true);
//
//        Proposal selectedP = (Proposal) proposal_T.getSelectionModel().getSelectedItem();
//
//        tf_ukm_nama.setText(selectedP.getNama_UKM());
//        ta_ukm_deskripsi.setText(selectedP.getDeskripsi_UKM());
//        tf_ukm_jumlah_modal.setText(String.valueOf(selectedP.getJumlah_modal_UKM()));
//        tf_dataDiri_nama.setText(selectedP.getNama());
//        tf_dataDiri_noIdentitas.setText(selectedP.getId());
//        ta_dataDiri_alamat.setText(selectedP.getAlamat());
//
//        cb_kategori.setValue(selectedP.getKategori());
//        cb_kategori.setDisable(true);
//
//        Proposal p = cariPropsal(selectedP);
//        if (null != p) {
//            updatedProposal = p;
//            ubayhBeneran.setDisable(false);
//        }
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        namaUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama_UKM"));
        modalUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("jumlah_modal_UKM"));
        pemilikUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategori_Tc.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        proposal_T.setItems(dataProposal);
    }
    
}
