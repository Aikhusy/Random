/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayBalok;

/**
 *
 * @author HAPE
 */
public class balok {
    public int panjang;
    public int lebar;
    public int tinggi;
    public balok(){};
    public balok(int p,int l,int t){
        panjang=p;
        lebar=l;
        tinggi=t;
    }
    public int hitungVolume(){
        return panjang*lebar*tinggi;
    }
}
