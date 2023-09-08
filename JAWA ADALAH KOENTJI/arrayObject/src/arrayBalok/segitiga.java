/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayBalok;

/**
 *
 * @author HAPE
 */
public class segitiga {
    public int alas;
    public int tinggi;
    
    public segitiga(int al,int tin){
        alas=al;
        tinggi=tin;
    }
    public float hitungLuas(){
        return alas*tinggi/2;
    }
    public float hitungKeliling(){
        return 3*alas;
    }
}
