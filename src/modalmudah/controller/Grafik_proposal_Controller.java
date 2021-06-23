/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import modalmudah.helper.xstream;
import modalmudah.model.Kategori;
import modalmudah.model.Proposal;

/* 
 * Tipe kategori
 */
class CountKategori {

    Kategori name;
    int count;

    public CountKategori(Kategori name) {
        this.name = name;
        this.count = 0;
    }

    public Kategori getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

/**
 * FXML Controller class
 *
 * @author yuan
 */
public class Grafik_proposal_Controller implements Initializable {

    private xstream<ArrayList<Proposal>> dataXml;
    private ArrayList<Proposal> proposalArray;
    private final XYChart.Series<String, Integer> data_chart_proposal
            = new XYChart.Series<>();

    @FXML
    private BarChart bc_kategori_proposal;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        proposalArray = new ArrayList<>();
        dataXml = new xstream(Proposal.XML_FILE_NAME, proposalArray);
        proposalArray = dataXml.loadXml();

        for (Kategori k : Kategori.values()) {
            data_chart_proposal.getData().add(new XYChart.Data<>(String.valueOf(k), 0));
        }

        proposalArray.forEach((Proposal proporsal) -> {
            System.out.println(String.valueOf(proporsal.getKategori()));
            data_chart_proposal.getData().forEach((XYChart.Data<String, Integer> k) -> {
//                XValue nama
//                /string YValue nilai / integer
                if (String.valueOf(proporsal.getKategori()).equals(k.getXValue())) {
                    k.setYValue(k.getYValue() + 1);
                }
            });
        });

        bc_kategori_proposal.getData().add(data_chart_proposal);
    }

}
