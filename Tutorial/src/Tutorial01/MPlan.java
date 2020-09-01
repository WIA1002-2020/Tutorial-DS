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
public class MPlan extends ISP{
    private int mbps, gb;

    public MPlan(int mbps, int gb) {
        super("MPlan",mbps,gb);
        price = 5*mbps + 0.8*gb;
    }    
}
