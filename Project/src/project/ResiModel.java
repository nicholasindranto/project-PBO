/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Orenji
 */
public class ResiModel {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/project";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    public ResiModel() {//untuk koneksi ke db
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readResi(){//utk baca data dr db
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][8]; //baris, kolom nya ada 5
            
            String query = "Select * from resi"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nomor_resi"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = resultSet.getString("tanggal");                
                data[jmlData][2] = resultSet.getString("pengirim");
                data[jmlData][3] = resultSet.getString("penerima");
                data[jmlData][4] = resultSet.getString("isi");
                data[jmlData][5] = resultSet.getString("jumlah");
                data[jmlData][6] = resultSet.getString("berat");
                data[jmlData][7] = resultSet.getString("biaya");
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public void insertResi(String no_resi, String tanggal, String pengirim, String penerima, String isi, String jumlah, String berat, String biaya){
        int jmlData=0;
        try {
            String query = "Select * from resi WHERE nomor_resi='" + no_resi + "'"; 
            System.out.println(no_resi + " " + tanggal + " " + pengirim + " " + penerima + " " + isi + " " + jumlah + " " + berat + " " + biaya);
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            
            if (jmlData==0) {//kalo gada datanya yg sama maka masukin
                query = "INSERT INTO `resi` (`nomor_resi`, `tanggal`, `pengirim`, `penerima`, `isi`, `jumlah`, `berat`, `biaya`) VALUES ('"+no_resi+"', '"+tanggal+"', '"+pengirim+"', '"+penerima+"', '"+isi+"', '"+jumlah+"', '"+berat+"', '"+biaya+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }else {//kalo ada gadimasukin
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void updateResi(String no_resi, String tanggal, String pengirim, String penerima, String isi, String jumlah, String berat, String biaya){
        int jmlData=0;
         try {
           String query = "Select * from resi WHERE nomor_resi='" + no_resi + "'"; 
           ResultSet resultSet = statement.executeQuery(query);
           
            while (resultSet.next()){ 
                jmlData++;
            }
           
            if (jmlData==1) {
               query = "UPDATE `resi` SET `nomor_resi` = '"+no_resi+"', `tanggal` = '"+tanggal+"', `pengirim` = '"+pengirim+"', `penerima` = '"+penerima+"', `isi` = '"+isi+"', `jumlah` = '"+jumlah+"', `berat` = '"+berat+"', `biaya` = '"+biaya+"' WHERE `resi`.`nomor_resi` = '"+no_resi+"';";
               statement = (Statement) koneksi.createStatement();
               statement.executeUpdate(query); //execute querynya
               System.out.println("Berhasil diupdate");
               JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM `resi`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public void deleteResi (String no_resi) {
        try{
            String query = "DELETE FROM resi WHERE `resi`.`nomor_resi` = '"+no_resi+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
    
    public String[][] cariResi(String no_resi){
        try{
            int jmlData = 0;
            
            String query = "Select * from resi WHERE nomor_resi LIKE '%" + no_resi + "%'"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            
            String data[][] = new String[jmlData][8]; //baris, kolom nya ada 3
            
            
            if (jmlData == 0) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            }
            else {
                jmlData = 0;
                query = "Select * from resi WHERE nomor_resi LIKE '%" + no_resi + "%'"; 
                resultSet = statement.executeQuery(query);
                while (resultSet.next()){
                    data[jmlData][0] = resultSet.getString("nomor_resi"); //harus sesuai nama kolom di mysql
                    data[jmlData][1] = resultSet.getString("tanggal");                
                    data[jmlData][2] = resultSet.getString("pengirim");
                    data[jmlData][3] = resultSet.getString("penerima");
                    data[jmlData][4] = resultSet.getString("isi");
                    data[jmlData][5] = resultSet.getString("jumlah");
                    data[jmlData][6] = resultSet.getString("berat");
                    data[jmlData][7] = resultSet.getString("biaya");
                    jmlData++;
                }
                
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
}
