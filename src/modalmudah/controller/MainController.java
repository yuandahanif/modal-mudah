/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import modalmudah.helper.OpenScene;

/**
 *
 * @author user
 */
public class MainController {

    OpenScene OS = new OpenScene();

    @FXML
    private BorderPane mainPane;

    @FXML
    private void daftarProposal(ActionEvent event) {
        Pane halaman = OS.getPane("create_proposal_view");
        mainPane.setCenter(halaman);
    }
}