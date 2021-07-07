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

import javafx.stage.Modality;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;
import modalmudah.helper.ImageHelper;
import modalmudah.helper.OpenScene;

/**
 * FXML Controller class
 *
 * @author yuan
 */
public class TableView_proposal_Controller implements Initializable {

    OpenScene OS = new OpenScene();
    Alert warning = new Alert(Alert.AlertType.WARNING);
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
    @FXML
    private Button b_refresh;

    @FXML
    private void handleRefreshAction(ActionEvent event) {
        try {
            hapus.setDisable(true);
            ubah.setDisable(true);

            loadXmlData();
        } catch (NumberFormatException e) {
        }
    }

    @FXML
    private void handleTableClick(MouseEvent event) {
        hapus.setDisable(false);
        ubah.setDisable(false);
    }

    @FXML
    private void handleUpdateAction(ActionEvent event) throws IOException {
        try {
            // do something with selected proosal
            int selectedIndex;
            Proposal selectedProposal;
            selectedProposal = (Proposal) proposal_T.getSelectionModel().getSelectedItem();
            selectedIndex = proposal_T.getSelectionModel().getSelectedIndex();

            if (selectedProposal != null) {
                // deselect proposal
                proposal_T.getSelectionModel().select(null);
                hapus.setDisable(true);
                ubah.setDisable(true);

                // send selected proposal to update view
                Window2_update_Controller controller = new Window2_update_Controller();
                controller.setProposalArrayList(proposalArray);
                controller.setDataXml(dataXml);
                controller.setProposal(selectedProposal, selectedIndex);

                FXMLLoader loader = OS.load("update_proposal_view");
                loader.setController(controller);

                Stage dialogStage = new Stage();
                dialogStage.setTitle("Update Proposal");
                dialogStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(loader.load());
                dialogStage.setScene(scene);
                // Show the dialog
                dialogStage.show();

                // sata window update di close
                dialogStage.setOnHiding((WindowEvent e) -> {
                    loadXmlData();
                });
            } else {
                warning.setContentText("Tidak ada data di tabel yang dipilih.");
                warning.showAndWait();
            }

        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }

    }

    //tombol hapus
    @FXML
    private void handleHapusButtonAction(ActionEvent event) {
        ObservableList<Proposal> selectedProposal, allProposals;
        allProposals = proposal_T.getItems();
        selectedProposal = proposal_T.getSelectionModel().getSelectedItems();

        if (selectedProposal.size() > 0) {
            // hapus dari tabel
            selectedProposal.forEach(allProposals::remove);
            proposal_T.getSelectionModel().select(null);
        } else {
            warning.setContentText("Tidak ada data di tabel yang dipilih.");
            warning.showAndWait();
        }

        // save to xml
        ArrayList<Proposal> dataProposalbaru = new ArrayList<>(allProposals);
        dataXml.saveToXML(dataProposalbaru);

        hapus.setDisable(true);
        ubah.setDisable(true);
    }

    private void loadXmlData() {
        proposalArray = dataXml.loadXml();
        dataProposal = observableArrayList(proposalArray);
        proposal_T.setItems(dataProposal);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        warning.setTitle("Tabel");

        hapus.setDisable(true);
        ubah.setDisable(true);

        hapus.setGraphic(new ImageView(ImageHelper.getImage("trash.png")));
        ubah.setGraphic(new ImageView(ImageHelper.getImage("pen.png")));
        b_refresh.setGraphic(new ImageView(ImageHelper.getImage("refresh.png")));

        namaUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama_UKM"));
        modalUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("jumlah_modal_UKM"));
        pemilikUKM_Tc.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kategori_Tc.setCellValueFactory(new PropertyValueFactory<>("kategori"));

        dataXml = new xstream(Proposal.XML_FILE_NAME, proposalArray);
        loadXmlData();
    }

}
