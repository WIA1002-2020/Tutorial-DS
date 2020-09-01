/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial02;

/**
 *
 * @author muham
 */
public class SpecialEncoding<T> {
    private T[] t;

    public SpecialEncoding(T[] t) {
        this.t = t;
    }
    
    public String encode(T u) {
        if (u instanceof Integer) {
            Integer num = (Integer) u;
            switch (num) {
                case 0:
                    return "Copy";
                case 1:
                    return "Delete";
                case 2:
                    return "Insert";
                case 3:
                    return "Print";
                case 4:
                    return "Rename";
                case 5:
                    return "Paste";
                default:
                    break;
            }
        } else if (u instanceof Character) {
            Character c = (Character) u;
            switch (c) {
                case 'C':
                    return "Copy";
                case 'D':
                    return "Delete";
                case 'I':
                    return "Insert";
                case 'P':
                    return "Print";
                case 'R':
                    return "Rename";
                case 'V':
                    return "Paste";
                default:
                    break;
            }
        }
        return "";
    }
    
    @Override
    public String toString(){
        String str = "The Code is ";
        for (T arr : t) 
            str += arr + " ";
        str += "\nThe Command is ";
        for (T arr : t) 
            str += encode(arr) + " ";
        return str;
    }
}
