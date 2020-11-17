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

/**
 *
 * @author Gilbert
 */
public class DatabaseController {
    static DatabaseHandler conn = new DatabaseHandler();

    // SELECT ALL
//    public static ArrayList<DataUser> getAllUsers() {
//        ArrayList<DataUser> users = new ArrayList<>();
//        conn.connect();
//        String query = "SELECT * FROM datauser";
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                DataUser user = new DataUser();
//                user.setNIK(rs.getString("nik"));
//                user.setNama(rs.getString("nama"));
//                user.setTempatLahir(rs.getString("tempatLahir"));
//                user.setTglLahir(rs.getString("gender"));
//                user.setGoldar(rs.getString("goldar"));
//                user.setAlamat(rs.getString("alamat"));
//                user.setRTRW(rs.getString("rtrw"));
//                user.setKecamatan(rs.getString("kecamatan"));
//                user.setKelDesa(rs.getString("kelDesa"));
//                user.setAgama(rs.getString("agama"));
//                user.setStatusPerkawinan(rs.getString("statusPerkawinan"));
//                user.setPekerjaan(rs.getString("pekerjaan"));
//                user.setKewarganegaraan(rs.getString("kewarganegaraan"));
//                user.setFoto(rs.getString("foto"));
//                user.setTtd(rs.getString("ttd"));
//                user.setTempatPembuatan(rs.getString("tempatPembuatan"));
//                user.setTglPembuatan(rs.getString("tglPembuatan"));
//                user.setBerlakuHingga(rs.getString("berlakuHingga"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (users);
//    }
//
//    // SELECT WHERE
//    public static DataUser getUser(String nik) {
//        conn.connect();
//        String query = "SELECT * FROM datauser WHERE nik='" + nik + "'";
//        DataUser user = new DataUser();
//        try {
//            Statement stmt = conn.con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                user.setNIK(rs.getString("nik"));
//                user.setNama(rs.getString("nama"));
//                user.setTempatLahir(rs.getString("tempatLahir"));
//                user.setTglLahir(rs.getString("tglLahir"));
//                user.setGender(rs.getString("gender"));
//                user.setGoldar(rs.getString("goldar"));
//                user.setAlamat(rs.getString("alamat"));
//                user.setRTRW(rs.getString("rtrw"));
//                user.setKecamatan(rs.getString("kecamatan"));
//                user.setKelDesa(rs.getString("kelDesa"));
//                user.setAgama(rs.getString("agama"));
//                user.setStatusPerkawinan(rs.getString("statusPerkawinan"));
//                user.setPekerjaan(rs.getString("pekerjaan"));
//                user.setKewarganegaraan(rs.getString("kewarganegaraan"));
//                user.setFoto(rs.getString("foto"));
//                user.setTtd(rs.getString("ttd"));
//                user.setTempatPembuatan(rs.getString("tempatPembuatan"));
//                user.setTglPembuatan(rs.getString("tglPembuatan"));
//                user.setBerlakuHingga(rs.getString("berlakuHingga"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (user);
//    }
//    
//    // INSERT
//    public static boolean insertNewUser(DataUser user) {
//        conn.connect();
//        String query = "INSERT INTO datauser VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement stmt = conn.con.prepareStatement(query);
//            stmt.setString(1, user.getNIK());
//            stmt.setString(2, user.getNama());
//            stmt.setString(3, user.getTempatLahir());
//            stmt.setString(4, user.getTglLahir());
//            stmt.setString(5, user.getGender());
//            stmt.setString(6, user.getGoldar());
//            stmt.setString(7, user.getAlamat());
//            stmt.setString(8, user.getRTRW());
//            stmt.setString(9, user.getKecamatan());
//            stmt.setString(10, user.getKelDesa());
//            stmt.setString(11, user.getAgama());
//            stmt.setString(12, user.getStatusPerkawinan());
//            stmt.setString(13, user.getPekerjaan());
//            stmt.setString(14, user.getKewarganegaraan());
//            stmt.setString(15, user.getFoto());
//            stmt.setString(16, user.getTtd());
//            stmt.setString(17, user.getTempatPembuatan());
//            stmt.setString(18, user.getBerlakuHingga());
//            stmt.setString(19, user.getTglPembuatan());
//            stmt.executeUpdate();
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }
//
//    // UPDATE
//    public static boolean updateUser(DataUser user, Boolean fcFoto, Boolean fcTtd) {
//        conn.connect();
//        String query = null;
//        if(fcFoto == true && fcTtd == true){
//            query = "UPDATE datauser SET nama='" + user.getNama() + "', "
//                + "tempatLahir='" + user.getTempatLahir() + "', "
//                + "tglLahir='" + user.getTglLahir() + "', "
//                + "gender='" + user.getGender() + "', "
//                + "goldar='" + user.getGoldar() + "', "
//                + "alamat='" + user.getAlamat() + "', "
//                + "rtrw='" + user.getRTRW() + "', "
//                + "kecamatan='" + user.getKecamatan() + "', "
//                + "kelDesa='" + user.getKelDesa() + "', "
//                + "agama='" + user.getAgama() + "', "
//                + "statusPerkawinan='" + user.getStatusPerkawinan() + "', "
//                + "pekerjaan='" + user.getPekerjaan() + "', "
//                + "kewarganegaraan='" + user.getKewarganegaraan() + "', "
//                + "foto='" + user.getFoto() + "', "
//                + "ttd='" + user.getTtd() + "', "
//                + "tempatPembuatan='" + user.getTempatPembuatan() + "', "
//                + "berlakuHingga='" + user.getBerlakuHingga() + "', "
//                + "tglPembuatan='" + user.getTglPembuatan() + "' "
//                + " WHERE nik='" + user.getNIK() + "'";
//        } else if(fcFoto == true && fcTtd == false){
//            query = "UPDATE datauser SET nama='" + user.getNama() + "', "
//                + "tempatLahir='" + user.getTempatLahir() + "', "
//                + "tglLahir='" + user.getTglLahir() + "', "
//                + "gender='" + user.getGender() + "', "
//                + "goldar='" + user.getGoldar() + "', "
//                + "alamat='" + user.getAlamat() + "', "
//                + "rtrw='" + user.getRTRW() + "', "
//                + "kecamatan='" + user.getKecamatan() + "', "
//                + "kelDesa='" + user.getKelDesa() + "', "
//                + "agama='" + user.getAgama() + "', "
//                + "statusPerkawinan='" + user.getStatusPerkawinan() + "', "
//                + "pekerjaan='" + user.getPekerjaan() + "', "
//                + "kewarganegaraan='" + user.getKewarganegaraan() + "', "
//                + "foto='" + user.getFoto() + "', "
//                + "tempatPembuatan='" + user.getTempatPembuatan() + "', "
//                + "berlakuHingga='" + user.getBerlakuHingga() + "', "
//                + "tglPembuatan='" + user.getTglPembuatan() + "' "
//                + " WHERE nik='" + user.getNIK() + "'";
//        } else if(fcFoto == false && fcTtd == true){
//            query = "UPDATE datauser SET nama='" + user.getNama() + "', "
//                + "tempatLahir='" + user.getTempatLahir() + "', "
//                + "tglLahir='" + user.getTglLahir() + "', "
//                + "gender='" + user.getGender() + "', "
//                + "goldar='" + user.getGoldar() + "', "
//                + "alamat='" + user.getAlamat() + "', "
//                + "rtrw='" + user.getRTRW() + "', "
//                + "kecamatan='" + user.getKecamatan() + "', "
//                + "kelDesa='" + user.getKelDesa() + "', "
//                + "agama='" + user.getAgama() + "', "
//                + "statusPerkawinan='" + user.getStatusPerkawinan() + "', "
//                + "pekerjaan='" + user.getPekerjaan() + "', "
//                + "kewarganegaraan='" + user.getKewarganegaraan() + "', "
//                + "ttd='" + user.getTtd() + "', "
//                + "tempatPembuatan='" + user.getTempatPembuatan() + "', "
//                + "berlakuHingga='" + user.getBerlakuHingga() + "', "
//                + "tglPembuatan='" + user.getTglPembuatan() + "' "
//                + " WHERE nik='" + user.getNIK() + "'";
//        } else if(fcFoto == false && fcTtd == false){
//            query = "UPDATE datauser SET nama='" + user.getNama() + "', "
//                + "tempatLahir='" + user.getTempatLahir() + "', "
//                + "tglLahir='" + user.getTglLahir() + "', "
//                + "gender='" + user.getGender() + "', "
//                + "goldar='" + user.getGoldar() + "', "
//                + "alamat='" + user.getAlamat() + "', "
//                + "rtrw='" + user.getRTRW() + "', "
//                + "kecamatan='" + user.getKecamatan() + "', "
//                + "kelDesa='" + user.getKelDesa() + "', "
//                + "agama='" + user.getAgama() + "', "
//                + "statusPerkawinan='" + user.getStatusPerkawinan() + "', "
//                + "pekerjaan='" + user.getPekerjaan() + "', "
//                + "kewarganegaraan='" + user.getKewarganegaraan() + "', "
//                + "tempatPembuatan='" + user.getTempatPembuatan() + "', "
//                + "berlakuHingga='" + user.getBerlakuHingga() + "', "
//                + "tglPembuatan='" + user.getTglPembuatan() + "' "
//                + " WHERE nik='" + user.getNIK() + "'";
//        }
//        try {
//            Statement stmt = conn.con.createStatement();
//            stmt.executeUpdate(query);
//            return (true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return (false);
//        }
//    }

    // DELETE
    public static boolean deleteData(String nik) {
        conn.connect();

        String query = "DELETE FROM datauser WHERE nik='" + nik + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
}