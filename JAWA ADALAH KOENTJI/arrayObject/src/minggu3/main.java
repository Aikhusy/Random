/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minggu3;

/**
 *
 * @author HAPE
 */
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner c= new Scanner(System.in);
        persegiPanjang[] ppArray = new persegiPanjang[3];
        ppArray[0]=new persegiPanjang();
        ppArray[0].panjang=110;
        ppArray[0].lebar= 30;
        
        ppArray[1]=new persegiPanjang();
        ppArray[1].panjang=80;
        ppArray[1].lebar=40;
        
        ppArray[2]=new persegiPanjang();
        ppArray[2].panjang=100;
        ppArray[2].lebar=20;
        
        for (int i=0; i<3;i++){
            System.out.println("Persegi Panjang ke-"+i+"panjang: "+ppArray[i].panjang+" lebar: "+ppArray[i].lebar);
        }
        
        /*for (int i=0;i<3;i++){
            ppArray[i]=new persegiPanjang();
            System.out.println("persegi panjang ke: "+ i);
            System.out.print( "masukkan panjang: ");
            ppArray[i].panjang = c.nextInt();
            System.out.print( "masukkan lebar: ");
            ppArray[i].lebar = c.nextInt();
        }*/
        //for (int i=0; i<3;i++){
        //    System.out.println("Persegi Panjang ke-"+i+"panjang: "+ppArray[i].panjang+" lebar: "+ppArray[i].lebar);
        //}
    }
}
