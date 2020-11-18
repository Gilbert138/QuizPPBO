/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseController;
import Model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilbert
 */
public class PanelQuiz extends JFrame implements ActionListener {

    JFrame frame_mainMenu;
    JButton btn_inputDataJurusan, btn_printDataJurusan, btn_inputDataMhs, btn_lihatDataMhs;

    public PanelQuiz() {
        frame_mainMenu = new JFrame("MyITHB");
        frame_mainMenu.setSize(450, 250);
        frame_mainMenu.setLocationRelativeTo(null);
        frame_mainMenu.getContentPane().setBackground(new java.awt.Color(208, 224, 247));

        Font fontZ = new Font("Trebuchet MS", Font.BOLD, 12);

        // Button Input Jurusan
        btn_inputDataJurusan = new JButton("Input Data Jurusan");
        btn_inputDataJurusan.setBounds(13, 30, 200, 70);
        btn_inputDataJurusan.addActionListener(this);
        btn_inputDataJurusan.setFont(fontZ);
        btn_inputDataJurusan.setBackground(Color.yellow);

        // Print Button
        btn_printDataJurusan = new JButton("Print Data Jurusan");
        btn_printDataJurusan.setBounds(221, 30, 200, 70);
        btn_printDataJurusan.addActionListener(this);
        btn_printDataJurusan.setFont(fontZ);
        btn_printDataJurusan.setBackground(Color.yellow);

        // Button Input Mahasiswa
        btn_inputDataMhs = new JButton("Input Data Mahasiswa");
        btn_inputDataMhs.setBounds(13, 110, 200, 70);
        btn_inputDataMhs.addActionListener(this);
        btn_inputDataMhs.setFont(fontZ);
        btn_inputDataMhs.setBackground(Color.yellow);

        // Print Button
        btn_lihatDataMhs = new JButton("Print Data Mahasiswa/Jurusan");
        btn_lihatDataMhs.setBounds(221, 110, 200, 70);
        btn_lihatDataMhs.addActionListener(this);
        btn_lihatDataMhs.setFont(fontZ);
        btn_lihatDataMhs.setBackground(Color.yellow);

        // Add Frame
        frame_mainMenu.add(btn_inputDataJurusan);
        frame_mainMenu.add(btn_printDataJurusan);
        frame_mainMenu.add(btn_inputDataMhs);
        frame_mainMenu.add(btn_lihatDataMhs);
        frame_mainMenu.setLayout(null);
        frame_mainMenu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Input Data Jurusan":
                frame_mainMenu.setVisible(false);
                new PanelInputJurusan();
                break;
            case "Print Data Jurusan":
                frame_mainMenu.setVisible(false);
                Jurusan newJur = new Jurusan();
                newJur.printJurusan();
                break;
            case "Input Data Mahasiswa":
                frame_mainMenu.setVisible(false);
                new PanelInputJurusan();
                break;
            default:
                System.exit(0);
                break;
        }
    }
}
