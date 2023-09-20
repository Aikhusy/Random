/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3;
import java.util.Scanner;
/**
 *
 * @author HAPE
 */
public class sumMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=================================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta. Misal 5.9)");
        System.out.print("Masukkan jumlah bulan : ");
        int elm = sc.nextInt();
        
        sum sm = new sum(elm);
        System.out.println("=================================================");
        for(int i = 0; i < sm.elemen; i++){
        System.out.print("Masukkan untung bulan ke-"+ (i + 1) +" = ");
        sm.keuntungan[i] = sc.nextDouble();
        }
        
        System.out.println("=================================================");
        System.out.println("Algoritma Brute Force");
        System.out.println("Total keuntungan perusahan selama "+ sm.elemen +" bulan adalah = "+ sm.totalBF(sm.keuntungan));
        System.out.println("=================================================");
        System.out.println("Total keuntungan perusahan selama "+ sm.elemen +" bulan adalah = "+ sm.totalDC(sm.keuntungan, 0, sm.elemen-1));
        
    
        
    }
}
