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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import modalmudah.model.Proposal;
/**
 *
 * @author user
 */
public class BaruController implements Initializable {

    XYChart.Series<String, Integer> dataProposalUntukBC = new XYChart.Series<>();
    ObservableList<Proposal> dataProposal = observableArrayList(new Proposal("22", "yuanda", "Bumi", "123456", "Kisaragi", "Evil company", 200000000, "tidak ada", "Entertaiment"));
    int proposalIndex;
    Proposal updatedProposal = null;
    String[] kategori = {"Makana", "Pakaian", "Perumahan", "Jasa"};
    
    @FXML
    private Label label;

    @FXML
    private ChoiceBox kategori_Cb;

    @FXML
    private TextField namaUkm, fileProposal, jumlahModal, dataDiri_nama, dataDiri_noIdentitas;

    @FXML
    private TextArea deskripsi, dataDiri_alamat;

    @FXML
    private Button submit, hapus, ubah, ubayhBeneran;    
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            String ktg = kategori_Cb.getValue().toString();
            dataProposal.add(new Proposal(dataDiri_noIdentitas.getText(),
                    dataDiri_nama.getText(),
                    dataDiri_alamat.getText(),
                    "0",
                    namaUkm.getText(),
                    deskripsi.getText(),
                    Integer.parseInt(jumlahModal.getText()),
                    fileProposal.getText(),
                    ktg));

            dataProposalUntukBC.getData().forEach((XYChart.Data<String, Integer> k) -> {
                // XValue nama/string
                // YValue nilai/integer
                if (ktg.equals(k.getXValue())) {
                    k.setYValue(k.getYValue() + 1);
                }
            });
        } catch (NumberFormatException e) {
        }

    }
    
        @FXML
    private void handleClearButtonAction(ActionEvent event) {
        kategori_Cb.setDisable(false);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
