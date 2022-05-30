/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResiView movieView = new ResiView();//mvc biasa
        ResiModel movieModel = new ResiModel();
        ResiController movieController = new ResiController(movieModel, movieView);
    }
    
}
