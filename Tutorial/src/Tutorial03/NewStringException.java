/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial03;

/**
 *
 * @author muham
 */
public class NewStringException extends Exception {

    public NewStringException() {
        super("the length of the string is greater than 12");
    }
}
