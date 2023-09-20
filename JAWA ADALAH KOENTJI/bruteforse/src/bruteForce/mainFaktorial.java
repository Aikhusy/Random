/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bruteForce;

/**
 *
 * @author HAPE
 */
import java.util.Scanner;
public class mainFaktorial {
    public static void main(String[] args) {
        Scanner c = new Scanner (System.in);
        System.out.println("========================");
        System.out.println("masukkan banyak angka : ");
        int elemen=c.nextInt();
        faktorial [] fk = new faktorial [elemen];
        for (int i=0;i<elemen;i++){
            fk[i]= new faktorial();
            System.out.println("========================");
            System.out.print("input nilai ke-"+ (i+1)+" : ");
            fk[i].nilai=c.nextInt();    
            
        }
        System.out.println("========================");
        System.out.println("Brute Force");
        long startTime = System.currentTimeMillis();
        for (int j=0;j<elemen;j++){
                System.out.println(" nilai : "+fk[j].nilai+" adalah : "+ fk[j].faktorialBF(fk[j].nilai));
            }
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
        
        System.out.println("========================");
        System.out.println("Divide Conqueror");
        long startTime1 = System.currentTimeMillis();
        for (int j=0;j<elemen;j++){
                System.out.println(" nilai : "+fk[j].nilai+" adalah : "+ fk[j].faktorialDC(fk[j].nilai));
            }
        long endTime1 = System.currentTimeMillis();
        System.out.println("That took " + (endTime1 - startTime1) + " milliseconds");
    }
}
