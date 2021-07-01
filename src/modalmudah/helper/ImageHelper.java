/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.helper;

import javafx.scene.image.Image;

/**
 *
 * @author yuan
 */
public class ImageHelper {

    public static Image getImage(String filename) {
        Image image = null;
        try {
            image = new Image(modalmudah.ModalMudah.class.getResourceAsStream("/modalmudah/assets/" + filename));
        } catch (Exception e) {
        }
        return image;
    }
}
