 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulated_annealing;

import java.util.Random;


public class SIMULATED_ANNEALING {

    private static double nilai_minimum(double x1, double x2){
        double hasil = 0;
        hasil = -(Math.abs(Math.sin(x1)*Math.cos(x2)*Math.exp(Math.abs(1-(Math.sqrt((x1*x1)+(x2*x2))/3.14))))); //rumus mencari nilai minimum fungsi
        return hasil;
    }
    
    private static double NewGenerate(double x1){ //untuk mencari titik awal
        double operator = Math.random()*-2; 
        
        if(x1 < 0){ //  membandingkan jika kurang dari 0 akan mengeksekusi 
            
            
            if(x1 > -1) { // karena udah termasuk batas kurang dari pada 0, jadi batasnya -1 sampai 0
                
                return x1;
            } 
            else{
                x1 = (operator)*-1; // jika angkanya kurang dari min 1, seperti -2 dsb. mengeksekusi di bawah ini agar hasilnya -0
                
                return x1;
            }
        } else {
            x1 = operator*-1; // jika x1 positif seperti 1,2,3  maka eksekusi program dibawah ini agar mendapatkan nilai kurang dari pada 0
            
            return x1;
        }  
    }
    
    private static double Melakukanrandom(double x1){ //untuk menentukan angka random pada x1 dan x2
       Random random = new Random();
       return (random.nextDouble() * 20.0d) - 10.0d;
    }
    
    public static double random(double A) {  
        double hasil;
        hasil = (double) Math.random() * A;
        return hasil;
    }
    
    public static void tampilan(double A, double B,double C, double x1, double x2) { //Menampilkan hasil output 
        System.out.println("Nilai X1 : " +x1);
        System.out.println("Nilai X2 : " +x2);
        System.out.println("Nilai T : " +A);
        System.out.println("Nilai Probabilitas E : " +B);
        System.out.println("Nilai Eb : " +C);
        System.out.println("");
    }
    
    public static void main(String[] args) { 
        double x1 = Melakukanrandom(10);
        double x2 = Melakukanrandom(10);
        setget C = new setget(x1, x2);
        setget B = C;
        double Eb = nilai_minimum (B.getX1(), B.getX2()); //menggetter x1 dan x2
        double T = 200;
        double alpha = 0.87;
        setget N;
        double En,Ec,AE,e;
        while(T > 1){ 
            for(int L=1; L<27; L++){
                x1 = B.getX1() + Melakukanrandom(10);
                x2 = B.getX2() + Melakukanrandom(10);
                if(((x1 > -10) && (10 > x1)) && ((x2 > -10) && (10 > x2))){
                    N = new setget(x1, x2);
                    En = nilai_minimum (N.getX1(), N.getX2());
                    Ec = Eb;
                    AE = En - Eb;
                    if(En < Eb){
                        B = N;
                        Eb = En;
                    } else{
                        double r = Math.random(); 
                        e = Math.exp(-1*(AE)/T);
                        if(r < e){
                            B = N;
                            Eb = En;
                        }
                    }
                    System.out.println(Ec + " " + Eb+ " " + En);
                    tampilan(T,AE,Eb,B.getX1(),B.getX2());
                }
            }
            T = T * alpha;
        }
    }
}
