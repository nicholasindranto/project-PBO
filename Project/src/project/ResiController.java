/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Orenji
 */
public class ResiController {
    ResiModel resiModel;
    ResiView resiView;

    public ResiController(ResiModel resiModel, ResiView resiView) {
        this.resiModel = resiModel;
        this.resiView = resiView;
        
        if (resiModel.getBanyakData()!=0) {
            String[][] dataResi = resiModel.readResi();
            resiView.tabel.setModel((new JTable(dataResi, resiView.namaKolom)).getModel());
        }else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        resiView.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String no_resi = resiView.getNoResi();
                String tanggal = resiView.getTanggal();
                String pengirim = resiView.getPengirim();
                String penerima = resiView.getPenerima();
                String isi = resiView.getIsi();
                String jumlah = resiView.getJumlah();
                String berat = resiView.getBerat();
                String biaya = resiView.getBiaya();
                resiModel.insertResi(no_resi, tanggal, pengirim, penerima, isi, jumlah, berat, biaya);

                String[][] dataResi = resiModel.readResi();
                resiView.tabel.setModel((new JTable(dataResi, resiView.namaKolom)).getModel());
            }
        });
        
        resiView.btnTampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[][] dataResi = resiModel.readResi();
                resiView.tabel.setModel((new JTable(dataResi, resiView.namaKolom)).getModel());
            }
        });
        
        resiView.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String no_resi = resiView.getNoResi();
                String tanggal = resiView.getTanggal();
                String pengirim = resiView.getPengirim();
                String penerima = resiView.getPenerima();
                String isi = resiView.getIsi();
                String jumlah = resiView.getJumlah();
                String berat = resiView.getBerat();
                String biaya = resiView.getBiaya();
                resiModel.updateResi(no_resi, tanggal, pengirim, penerima, isi, jumlah, berat, biaya);

                String[][] dataResi = resiModel.readResi();
                resiView.tabel.setModel((new JTable(dataResi, resiView.namaKolom)).getModel());
            }
        });
        
        resiView.btnCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String no_resi = resiView.getNoResi();
                
                if (no_resi.equals("")) {
                    JOptionPane.showMessageDialog(null, "Data Kosong");
                }
                else {
                    String[][] dataResi = resiModel.cariResi(no_resi);
                    resiView.tabel.setModel((new JTable(dataResi, resiView.namaKolom)).getModel());
                }
                
            }
        });
        
        resiView.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                resiView.tfNoResi.setText("");
                resiView.tfTanggal.setText("");
                resiView.tfPengirim.setText("");
                resiView.tfPenerima.setText("");
                resiView.tfIsi.setText("");
                resiView.tfJumlah.setText("");
                resiView.tfBerat.setText("");
                resiView.tfBiaya.setText("");
            }
        });
        
        resiView.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int baris = resiView.tabel.getSelectedRow();
                int kolom = resiView.tabel.getSelectedColumn(); // ga kepake sekarang

                String dataterpilih = resiView.tabel.getValueAt(baris, 0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null,"Apa anda ingin menghapus nomor resi " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    resiModel.deleteResi(dataterpilih);
                    String[][] dataResi = resiModel.readResi();
                    resiView.tabel.setModel(new JTable(dataResi, resiView.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });
    }
}
