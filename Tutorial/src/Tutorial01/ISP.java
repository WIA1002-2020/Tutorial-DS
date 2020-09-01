/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial01;

/**
 *
 * @author muham
 */
public class ISP {
    protected String name;
    protected double price;
    protected int mbps, gb;

    public ISP(String name, int mbps, int gb) {
        this.name = name;
        this.mbps = mbps;
        this.gb = gb;
    }
    
    public void displayPlan(){
        System.out.println("Plan: "+ name + " with price RM: "+ price);
    }

    public int getMbps() {
        return mbps;
    }

    public int getGb() {
        return gb;
    }

    public double getPrice() {
        return price;
    }    
}
