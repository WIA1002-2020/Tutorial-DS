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
public class DPlan extends ISP{
    private int mbps, gb;

    public DPlan(int mbps, int gb) {
        super("Dplan",mbps,gb);
        price = 10*mbps + 0.2*gb;
    }  
}
