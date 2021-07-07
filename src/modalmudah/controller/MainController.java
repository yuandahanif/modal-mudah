/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import modalmudah.helper.ImageHelper;
import modalmudah.helper.OpenScene;

/**
 *
 * @author user
 */
public class MainController implements Initializable {

    OpenScene OS = new OpenScene();

    @FXML
    private AnchorPane Ap_navigation;

    @FXML
    private Button b_daftarProposal, b_tabelProposal, b_grafikProposal;

    @FXML
    private BorderPane mainPane;

    @FXML
    private void daftarProposal(ActionEvent event) {
        Pane halaman = OS.getPane("create_proposal_view");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void grafikProposal(ActionEvent event) {
        Pane halaman = OS.getPane("grafik_proposal_view");
        mainPane.setCenter(halaman);
    }

    @FXML
    private void tableProposal(ActionEvent event) {
        Pane halaman = OS.getPane("table_proposal_view");
        mainPane.setCenter(halaman);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Ap_navigation.setVisible(false);
        FXMLLoader halaman = OS.load("login_view");

        try {
            mainPane.setCenter(halaman.load());
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        b_daftarProposal.setGraphic(new ImageView(ImageHelper.getImage("pen.png")));
        b_tabelProposal.setGraphic(new ImageView(ImageHelper.getImage("table.png")));
        b_grafikProposal.setGraphic(new ImageView(ImageHelper.getImage("chart.png")));

    }
}
