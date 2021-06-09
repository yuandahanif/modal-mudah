/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modalmudah.model;

/**
 *
 * @author yuan
 */
public class Proposal {

    private final String id;
    private String nama;
    private String alamat;
    private String kontak;

    private String nama_UKM;
    private String deskripsi_UKM;
    private Integer jumlah_modal_UKM;
    private String file_UKM;

    public Proposal(String id, String nama, String alamat, String kontak, String nama_UKM, String deskripsi_UKM, Integer jumlah_modal_UKM, String file_UKM) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.kontak = kontak;
        this.nama_UKM = nama_UKM;
        this.deskripsi_UKM = deskripsi_UKM;
        this.jumlah_modal_UKM = jumlah_modal_UKM;
        this.file_UKM = file_UKM;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getNama_UKM() {
        return nama_UKM;
    }

    public void setNama_UKM(String nama_UKM) {
        this.nama_UKM = nama_UKM;
    }

    public String getDeskripsi_UKM() {
        return deskripsi_UKM;
    }

    public void setDeskripsi_UKM(String deskripsi_UKM) {
        this.deskripsi_UKM = deskripsi_UKM;
    }

    public Integer getJumlah_modal_UKM() {
        return jumlah_modal_UKM;
    }

    public void setJumlah_modal_UKM(Integer jumlah_modal_UKM) {
        this.jumlah_modal_UKM = jumlah_modal_UKM;
    }

    public String getFile_UKM() {
        return file_UKM;
    }

    public void setFile_UKM(String file_UKM) {
        this.file_UKM = file_UKM;
    }

}
