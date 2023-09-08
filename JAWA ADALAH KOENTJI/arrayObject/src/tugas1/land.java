/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1;

/**
 *
 * @author HAPE
 */
public class land {
    public int panjang;
    public int lebar;
    
    public land (int p,int l){
        panjang=p;
        lebar=l;
    }
    
    public int hitungLuas(){
        return panjang*lebar;
    }
}
