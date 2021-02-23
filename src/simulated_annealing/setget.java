/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulated_annealing;


public class setget {
     private double x1;
    private double x2;
    
    public setget(double x1, double x2){
        setX1(x1);
        setX2(x2);
    }
    
    public void setX1(double x1){
        this.x1 = x1;
    }
    public void setX2(double x2){
        this.x2 = x2;
    }
    public double getX1(){
        return x1;
    }
    public double getX2(){
        return x2;
    }
}
