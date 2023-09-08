/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arrayBalok;

/**
 *
 * @author HAPE
 */
public class mainSegitiga {
    public static void main(String[] args) {
        segitiga sgArr [] = new segitiga [4];
        sgArr[0]= new segitiga (10,4);
        sgArr[1]=new segitiga (20,10);
        sgArr[2]=new segitiga (15,6);
        sgArr[3]= new segitiga (25,10);
        
        for(int b=0;b<4;b++){
            System.out.println("luas : "+sgArr[b].hitungLuas());
            System.out.println("keliling : "+sgArr[b].hitungKeliling());
        }
    }
    
    
}
