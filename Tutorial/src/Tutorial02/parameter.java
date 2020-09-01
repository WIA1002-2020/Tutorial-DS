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
public class parameter<T> {

    private T t, u;

    public parameter(T t, T u) {
        this.t = t;
        this.u = u;
    }

    public String ans() {
        if (t instanceof String && u instanceof String) {
            if (t.equals(u)) {
                return "The string is equal";
            } else {
                return "The String is not equal";
            }
        } else if (t instanceof Integer && u instanceof Integer) {
            return "The sum of the integer is " + ((Integer) t + (Integer) u);
        } else {
            return "The sum of the double is " + ((Double) t + (Double) u);
        }
    }

    public String toString() {
        return "The parameters value are: " + t + " and " + u
                + "\n" + ans();
    }
}
