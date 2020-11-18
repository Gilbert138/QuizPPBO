/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import Model.*;
import Controller.DatabaseController;
/**
 *
 * @author Gilbert
 */
public class PanelInputJurusan implements ActionListener {
    
    JFrame jfr_registrasi = new JFrame("Register Jurusan");
    JLabel kodeLabel,namaLabel;
    JTextField kode,nama;
    JPanel Panel;
    JButton btn_submit;
    
    public PanelInputJurusan() {
        jfr_registrasi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfr_registrasi.getContentPane().setBackground(Color.white );
        jfr_registrasi.setResizable(true);
        jfr_registrasi.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfr_registrasi.setExtendedState(JFrame.MAXIMIZED_BOTH);

        Panel = new JPanel();
        Panel.setLayout(null);

        JLabel judulL = new JLabel("Jurusan: ");
        judulL.setBounds(200, 0, 150, 300);
        judulL.setFont(new Font("Calibri", Font.BOLD, 20));

        kodeLabel = new JLabel("Kode                  :");
        namaLabel = new JLabel("Nama                  :");

        kodeLabel.setBounds(200, 230, 150, 40);
        kodeLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        kode = new JTextField();
        kode.setBounds(360, 230, 350, 40);
        kode.setBorder(null);

        namaLabel.setBounds(200, 290, 150, 40);
        namaLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        nama = new JTextField();
        nama.setBounds(360, 290, 350, 40);
        nama.setBorder(null);    
        
        btn_submit = new JButton ("Submit");
        btn_submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn_submit.setBounds(200, 420, 150, 60);
        btn_submit.addActionListener(this);

        Panel.add(judulL);
        Panel.add(kodeLabel);
        Panel.add(namaLabel);
        Panel.add(kode);
        Panel.add(nama);
        Panel.add(btn_submit);

        jfr_registrasi.add(Panel);
        jfr_registrasi.setLocationRelativeTo(null);
        jfr_registrasi.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String kode = this.kode.getText();
        String nama = this.nama.getText();
        int a = JOptionPane.showOptionDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (a == JOptionPane.YES_OPTION) {
            if (nama.length() == 0 || kode.length() == 0) {
                JOptionPane.showMessageDialog(null, "Input all the data!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                Jurusan newJurusan = new Jurusan();
                newJurusan.setKode(kode);
                newJurusan.setNama(nama);
                if (DatabaseController.insertNewJurusan(newJurusan)) {
                    JOptionPane.showMessageDialog(null, "Registration Complete!\nPlease Login!");
                    jfr_registrasi.dispose();
                    new PanelQuiz();
                } else {
                    JOptionPane.showMessageDialog(null, "Data can't be inserted!", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
