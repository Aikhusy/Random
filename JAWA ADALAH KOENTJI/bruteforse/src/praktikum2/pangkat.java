/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum2;

/**
 *
 * @author HAPE
 */
public class pangkat {
    public int nilai,pangkat;
    
    public pangkat(int n,int p){
        nilai=n;
        pangkat=p;
    }
    
    public int pangkatBF(int a,int n){
        int hasil=1;
        for (int i=0;i<n;i++){
            hasil*=a;
        }
        return hasil;
    }
    
    public int pangkatDC(int a, int n){
        if (n==0){
            return 1;
        }
        else {
            if (n%2==1){
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2)*a);
            }
            else{
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2));
            }
        }
    }
}
