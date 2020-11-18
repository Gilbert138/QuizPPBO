/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;

/**
 *
 * @author Gilbert
 */
public class DatabaseController {

    static DatabaseHandler conn = new DatabaseHandler();

    // INSERT Jurusan 
    public static boolean insertNewJurusan(Jurusan jurusan) {
        conn.connect();
        String query = "INSERT INTO jurusan (kode,nama) VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, jurusan.getKode());
            stmt.setString(2, jurusan.getNama());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    // INSERT Mahasiswa 
    public static boolean insertNewMhs(Mahasiswa Mhs) {
        conn.connect();
        String query = "INSERT INTO mahasiswa (nim,nama,angkatan,kode_jurusan) VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, Mhs.getNim());
            stmt.setString(2, Mhs.getNama());
            stmt.setInt(3, Mhs.getAngkatan());
            stmt.setString(4, Mhs.getKode_jurusan());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    // SELECT ALL Jurusan
    public static ArrayList<Jurusan> getAllJurusan() {
        ArrayList<Jurusan> jurusan = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jurusan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan newJur = new Jurusan();
                newJur.setKode(rs.getString(rs.getString("kode")));
                newJur.setNama(rs.getString(rs.getString("nama")));
                jurusan.add(newJur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (jurusan);
    }
//
    // SELECT WHERE
    public static Mahasiswa getUser(String kodeJur) {
        conn.connect();
        String query = "SELECT * FROM mahasiswa WHERE kode_jurusan='" + kodeJur + "'";
        Mahasiswa Mhs = new Mahasiswa();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Mhs.setNim(rs.getString("nim"));
                Mhs.setNama(rs.getString("nama"));
                Mhs.setAngkatan(rs.getInt("angkatan"));
                Mhs.setKode_jurusan(rs.getString("kode_jurusan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (Mhs);
    }

}
