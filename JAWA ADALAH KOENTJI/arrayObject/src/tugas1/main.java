/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas1;
import java.util.Scanner;

/**
 *
 * @author HAPE
 */
public class main {
    public static void main(String[] args) {
         Scanner c= new Scanner(System.in);
         
         System.out.print("Total Tanah :");
         int n=c.nextInt();
         int temp=0,pan,leb,tempIndex=0;
         int luasTemp[]=new int[n];
         
         land landData []=new land[n];
         
         for (int b=0;b<n;b++){
             System.out.print("Panjang Tanah ke "+(b+1)+" : ");
             pan=c.nextInt();
             System.out.print("Lebar Tanah ke "+(b+1)+" : ");
             leb=c.nextInt();
             
             landData[b]=new land(pan,leb);
             
             luasTemp[b]=landData[b].hitungLuas();
             if (luasTemp[b]>temp){
                 temp=luasTemp[b];
                 tempIndex=b;
             }
             System.out.println("luas tanah ke "+ (b+1) +" : " +luasTemp[b]); 
             
         }
            System.out.println(" tanah terluas adalah tanah ke "+ (tempIndex+1) +" : "+temp);
    }
}
