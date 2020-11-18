/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilbert
 */
public class Jurusan {
    private String kode;
    private String nama;

    public Jurusan() {
    }

    public Jurusan(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void printJurusan(){
        ArrayList<Jurusan> listJur = new ArrayList<>();
        for(Jurusan jurusan: listJur){
            JOptionPane.showMessageDialog(null, jurusan.getKode()+"\n"+jurusan.getNama());
        }
    }
}
