/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.event.ActionEvent;//murni dari kodingan kakak yg di share di spada
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Orenji
 */
public class ResiView extends JFrame{
    JLabel lNoResi = new JLabel("No Resi");
    JLabel lTanggal = new JLabel("Tanggal");
    JLabel lPengirim = new JLabel("Pengirim");
    JLabel lPenerima = new JLabel("Penerima");
    JLabel lIsi = new JLabel("Isi");
    JLabel lJumlah = new JLabel("Jumlah");
    JLabel lBerat = new JLabel("Berat");
    JLabel lBiaya = new JLabel("Biaya");
    
    public JTextField tfNoResi = new JTextField();
    public JTextField tfTanggal = new JTextField();
    public JTextField tfPengirim = new JTextField();
    public JTextField tfPenerima = new JTextField();
    public JTextField tfIsi = new JTextField();
    public JTextField tfJumlah = new JTextField();
    public JTextField tfBerat = new JTextField();
    public JTextField tfBiaya = new JTextField();
    
    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnCari = new JButton("Cari");
    public JButton btnTampil = new JButton("Tampilkan Data");
    public JButton btnReset = new JButton("Clear");
    
    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"No Resi", "Tanggal", "Pengirim", "Penerima", "Isi", "Jumlah", "Berat", "Biaya"};

    public ResiView() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Resi");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(700,600);
        
        add(scrollPane);
        scrollPane.setBounds(20, 20, 500, 300);
        
        add(lNoResi);
        lNoResi.setBounds(530, 20, 90, 20);
        add(tfNoResi);
        tfNoResi.setBounds(530, 40, 130, 20);
        
        add(lTanggal);
        lTanggal.setBounds(530, 60, 90, 20);
        add(tfTanggal);
        tfTanggal.setBounds(530, 80, 130, 20);
        
        add(lPengirim);
        lPengirim.setBounds(530, 100, 90, 20);
        add(tfPengirim);
        tfPengirim.setBounds(530, 120, 130, 20);
        
        add(lPenerima);
        lPenerima.setBounds(530, 140, 90, 20);
        add(tfPenerima);
        tfPenerima.setBounds(530, 160, 130, 20);
        
        add(lIsi);
        lIsi.setBounds(530, 180, 90, 20);
        add(tfIsi);
        tfIsi.setBounds(530, 200, 130, 20);
        
        add(lJumlah);
        lJumlah.setBounds(530, 220, 90, 20);
        add(tfJumlah);
        tfJumlah.setBounds(530, 240, 130, 20);
        
        add(lBerat);
        lBerat.setBounds(530, 260, 90, 20);
        add(tfBerat);
        tfBerat.setBounds(530, 280, 130, 20);
        
        add(lBiaya);
        lBiaya.setBounds(530, 300, 90, 20);
        add(tfBiaya);
        tfBiaya.setBounds(530, 320, 130, 20);
        
        add(btnTambah);
        btnTambah.setBounds(530, 360, 130, 20);
        
        add(btnTampil);
        btnTampil.setBounds(530, 390, 130, 20);
        
        add(btnUpdate);
        btnUpdate.setBounds(530, 420, 130, 20);
        
        add(btnDelete);
        btnDelete.setBounds(530, 450, 130, 20);
        
        add(btnCari);
        btnCari.setBounds(530, 480, 130, 20);
        
        add(btnReset);
        btnReset.setBounds(530, 510, 130, 20);
    }
    
    public String getNoResi(){
        return tfNoResi.getText();
    }
    
    public String getTanggal(){
        return tfTanggal.getText();
    }
    
    public String getPengirim(){
        return tfPengirim.getText();
    }
    
    public String getPenerima(){
        return tfPenerima.getText();
    }
    
    public String getIsi(){
        return tfIsi.getText();
    }
    
    public String getJumlah(){
        return tfJumlah.getText();
    }
    
    public String getBerat(){
        return tfBerat.getText();
    }
    
    public String getBiaya(){
        return tfBiaya.getText();
    }
}
