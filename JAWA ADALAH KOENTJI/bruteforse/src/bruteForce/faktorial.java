/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bruteForce;

/**
 *
 * @author HAPE
 */
public class faktorial {
    public int nilai;
    public int faktorialBF(int n){
        int fakto =1;
        while (n!=1){
            fakto*=n;
            n-=1;
        }
        return fakto;
    }
    public int faktorialDC(int n){
        
        if (n==1){
            
            return 1;
        }
        else{
            int fakto=n * faktorialDC(n-1);
            return fakto;
        }
    }
}

