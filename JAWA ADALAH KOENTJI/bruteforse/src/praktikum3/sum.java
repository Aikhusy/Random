/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3;

/**
 *
 * @author HAPE
 */
public class sum {
    public int elemen;
    public double keuntungan[];
    public double total;
    
    sum(int elemen){
        this.elemen = elemen;
        this.keuntungan = new double[elemen];
        this.total = 0;
    }
    
    double totalBF(double arr[]){
        for(int i = 0; i < elemen; i++){
            total = total +arr[i];
        }
        return total;
    }
    
    double totalDC(double arr[], int awal, int akhir){
        if(awal == akhir){
            return arr[awal];
        } else if(awal < akhir){
            int mid = (awal + akhir) / 2;
            double lsum = totalDC(arr, awal, mid-1);
            double rsum = totalDC(arr, mid+1, akhir);
            return lsum + rsum + arr[mid];
        }
        return 0;
    }            
}
