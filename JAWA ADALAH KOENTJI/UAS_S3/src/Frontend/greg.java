/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frontend;
import Backend.Kategori;
import Backend.*;
/**
 *
 * @author HAPE
 */
public class greg {
    public static void main(String[] args) {
        Kategori Dessert = new Kategori().getById(1);
        Kategori Apetizer= new Kategori().getById(7);
        Menu kat1 = new Menu("Coup de nudele", 60000,Apetizer);
        Menu kat2 = new Menu("Cheesecake", 50000,Dessert);

        System.out.println(Dessert.getIdKategori());
        
        // test update
        
        

        // test delete
        

        // test select all
        for(Menu k : new Menu().getAll())
        {
        System.out.println(k.getIdMenu()+"Nama: " + k.getNamaMenu() + ", Ket: " + k.getKategori().getNamaKategori());
        }

        // test search

    }
}
