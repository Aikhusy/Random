/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum2;

/**
 *
 * @author HAPE
 */
import java.util.Scanner;
public class mainPangkat {
    public static void main(String[] args) {
        int angka,pankat;
        Scanner c=new Scanner(System.in);
        System.out.println("======================================");
        System.out.print(" input jumlah yang dihitung : ");
    
        int elemen = c.nextInt();
        pangkat png []= new pangkat [elemen];
        
        for (int i=0;i<elemen;i++){
            
            System.out.println("Masukksan angka ke-"+ (i+1) +" ");
            angka=c.nextInt();
            System.out.println("Masukksan pangkat ke-"+ (i+1) +" ");
            pankat=c.nextInt();
            png[i]= new pangkat(angka,pankat);
        }
        System.out.println("======================================");
        System.out.print(" 1. Brute force\n 2. Divide Conque ");
        String inputan=c.nextLine();
        
        if (inputan.equalsIgnoreCase("1")){
        for (int i=0;i<elemen;i++){
            System.out.println("nilai : "+png[i].nilai +" pangkat " +png[i].pangkat+" adalah : " + png[i].pangkatBF(png[i].nilai,png[i].pangkat));
        }
        }
        else {
        for (int i=0;i<elemen;i++){
            System.out.println("nilai : "+png[i].nilai +" pangkat " +png[i].pangkat+" adalah : " + png[i].pangkatDC(png[i].nilai,png[i].pangkat));
        }
        }    
    }      
}
