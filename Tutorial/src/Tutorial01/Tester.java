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
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Question 1
        Tarikh t = new Tarikh(25,7,2027);
        System.out.println(t.toString());
        System.out.println();
        
        //Question 2
        Sentence s = new Sentence("How are you?");
        System.out.println(s.toString());
        System.out.println();
        
        //Question 3
        DPlan d = new DPlan(5, 50);        
        MPlan m = new MPlan(5, 50);       
        System.out.println(d.getMbps() +"Mbps Subscription and "+ m.getGb() +"GB");
        d.displayPlan();
        m.displayPlan();
        if(d.getPrice() < m.getPrice()){
            System.out.println("DPlan is cheaper as compared to MPlan");
        }
        else{
            System.out.println("MPlan is cheaper as compared to DPlan");
        }
        System.out.println();
        
        SmartPhone sp[] = {new SmartPhone("Samsung", 1400),
                           new SmartPhone("Apple",2400),
                           new SmartPhone("Huawei",2000),
                           new SmartPhone("Xiaomi",700)};
        System.out.println("List of smartphone");
        for (int i = 0; i < sp.length; i++) {
            System.out.print(sp[i].toString());
        }
        SmartPhone temp;
        for (int i = 0; i < sp.length; i++) {
            for (int j = 0; j < sp.length; j++) {
                temp = sp[j];
                if (sp[j].compareTo(sp[i]) > 0) {
                    sp[j] = sp[i];
                    sp[i] = temp;
                }
            }
        }

        System.out.println("List of SmartPhone in ascending");
        for (int i =0; i < sp.length; i++) {
            System.out.print(sp[i].toString());
        }
        System.out.println();
    }
}
