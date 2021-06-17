/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.helper;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 *
 * @author yuan
 */
public class OpenScene {

    private Pane halaman;

    public Pane getPane(String filename) {

        try {
            URL fileView = modalmudah.ModalMudah.class.getResource("/modalmudah/view/" + filename + ".fxml");

            if (fileView == null) {
                throw new java.io.FileNotFoundException("File halaman tidak ditemukan");
            }

            halaman = FXMLLoader.load(fileView);
        } catch (IOException e) {
            System.out.println("Tidak ditemukan halaman tersebut");
        }

        return halaman;
    }
}
